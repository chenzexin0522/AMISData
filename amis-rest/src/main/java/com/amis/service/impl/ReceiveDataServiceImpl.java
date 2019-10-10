package com.amis.service.impl;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.dao.ReceiveDataDao;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;
import com.amis.entity.RelayMac;
import com.amis.entity.dto.RelayMacListDTO;
import com.amis.entity.dto.ReslutMontionData;
import com.amis.entity.dto.ReturnJieMotionDataDTO;
import com.amis.service.ReceiveDataService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Future;

/**
 * @ClassName ReceiveDataServiceImpl
 * @Description 接收数据
 * @Author chenzexin
 * @Date 2019/8/9 10:38
 **/

@Service
public class ReceiveDataServiceImpl implements ReceiveDataService {

    private static Map<String, ReturnJieMotionDataDTO[]> oldMotionDataEntityList = new HashMap<>();

    private static Map<String, ReturnJieMotionDataDTO[]> newMotionDataEntityList = new HashMap<>();

    private static int insertPointer = 0;           //插入指针

    public static List<float[]> dataListStatic ;

    private static Map<String,List<MotionDataEntity>> listMap = new HashMap<>();

    @Autowired
    private ReceiveDataDao receiveDataDao;




    @Override
    @Async("excetor")
    public ResponseVO insertMotionData(MotionDataEntity motionDataEntity){
            if (listMap.get(motionDataEntity.getMac()) == null){                //判断临时存储listMap是否为空，如果为空，就将motionDataEntity  put到listMap中
                List<MotionDataEntity> motionDataEntities = new ArrayList<>();
                long todayZeroDate = (new Date().getTime()/86400000L)*86400000L-28800000L;
                long dateUnix = motionDataEntity.getUnixdate()/1000L - todayZeroDate/1000L;		//获取今天unix时间/秒数
                motionDataEntity.setArrindex(dateUnix);			//设置motionDataEntity中的insertTime属性为当前unix时间
                motionDataEntities.add(motionDataEntity);
                listMap.put(motionDataEntity.getMac(),motionDataEntities);
            }else if (listMap.get(motionDataEntity.getMac()) != null){
                insertMemoryMotionData(motionDataEntity);
            }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


    @Override
    public String getListSize() {
        return String.valueOf(oldMotionDataEntityList.size());
    }

    @Override
    @Async("excetor")
    public Future<ResponseVO> queryDataCriteria(QueryDataCriteria queryDataCriteria) throws IOException {
        List<ReturnJieMotionDataDTO> returnMotionDataEntity = new ArrayList<>();              //最终list
        long startZeroDate = (queryDataCriteria.getStartDate()/86400000L)*86400000L-28800000L;      //计算出开始查询时间的凌晨整点unix时间。
        long endZeroDate = (queryDataCriteria.getEndDate()/86400000L)*86400000L-28800000L;          //计算出结束查询时间的凌晨整点unix时间。
        long todayZeroDate = (new Date().getTime()/86400000L)*86400000L-28800000L;                  //计算出今天时间的凌晨整点unix时间。
        long startIndex = queryDataCriteria.getStartDate()/1000L - startZeroDate/1000L;             //计算出开始查询的下标
        long endIndex = queryDataCriteria.getEndDate()/1000L - endZeroDate/1000L;                   //计算出结束查询的下标
        if (startZeroDate == todayZeroDate && endZeroDate==todayZeroDate){          //开始查询时间和结束查询时间都等于今天，进行内存查询
            List<ReturnJieMotionDataDTO> motionDataEntities = queryMemory(startZeroDate,endZeroDate,todayZeroDate,startIndex,endIndex,queryDataCriteria.getMac());
            ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
            if (motionDataEntities != null){
                returnMotionDataEntity.addAll(motionDataEntities);
            }
            responseVO.setData(returnMotionDataEntity);
        }
        if (startZeroDate != todayZeroDate){    //如果查询开始时间非等于今天，则进行数据库查询
            List<ReturnJieMotionDataDTO> motionDataEntities = queryDB(startZeroDate,endZeroDate,todayZeroDate,startIndex,endIndex,queryDataCriteria.getMac());           //调用查询数据库方法
            returnMotionDataEntity.addAll(motionDataEntities);
        }
        if (startZeroDate != todayZeroDate && endZeroDate == todayZeroDate){          //结束查询等于今天，进行内存查询
            List<ReturnJieMotionDataDTO> motionDataEntities = queryMemory(startZeroDate,endZeroDate,todayZeroDate,0,endIndex,queryDataCriteria.getMac());
            returnMotionDataEntity.addAll(motionDataEntities);
            ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
            responseVO.setData(returnMotionDataEntity);
        }
        if (queryDataCriteria.getAnalysisType() == 1){          //结果为true进行数据解析
            List<ReslutMontionData> motionDataEntityList = new ArrayList<>();
            for (ReturnJieMotionDataDTO returnJieMotionDataDTO :returnMotionDataEntity) {
                ReslutMontionData reslutMontionData = new ReslutMontionData();
                reslutMontionData.setMac(returnJieMotionDataDTO.getMac());
                reslutMontionData.setReceiveTime(returnJieMotionDataDTO.getReceiveTime3());
                reslutMontionData.setArrindex(returnJieMotionDataDTO.getArrindex());
                String analysisMotionData = returnJieMotionDataDTO.getMotionData1()+","+returnJieMotionDataDTO.getMotionData2()+","+returnJieMotionDataDTO.getMotionData3();
                String[] strArr = analysisMotionData.split(",");
                for (int i = 0; i < strArr.length; ++i){
                    List<float[]> analysisStrData = ByteToValue(strArr[i]);
                    reslutMontionData.setAx(ArrayUtils.addAll(reslutMontionData.getAx(),analysisStrData.get(0)));
                    reslutMontionData.setAy(ArrayUtils.addAll(reslutMontionData.getAy(),analysisStrData.get(1)));
                    reslutMontionData.setAz(ArrayUtils.addAll(reslutMontionData.getAz(),analysisStrData.get(2)));
                    reslutMontionData.setGx(ArrayUtils.addAll(reslutMontionData.getGx(),analysisStrData.get(3)));
                    reslutMontionData.setGy(ArrayUtils.addAll(reslutMontionData.getGy(),analysisStrData.get(4)));
                    reslutMontionData.setGz(ArrayUtils.addAll(reslutMontionData.getGz(),analysisStrData.get(5)));
                }
                motionDataEntityList.add(reslutMontionData);
            }
            ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
            responseVO.setData(motionDataEntityList);
            return new AsyncResult<>(responseVO);
        }else if (queryDataCriteria.getAnalysisType() == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
            responseVO.setData(returnMotionDataEntity);
            return new AsyncResult<>(responseVO);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnMotionDataEntity);
        return new AsyncResult<>(responseVO);
    }


    @Override
    public int newBuildTab() {
        if (insertPointer == 0){    //如果当前指针式0，将指针替换为1
            insertPointer = 1;
            long todayZeroDate = (new Date().getTime()/86400000L)*86400000L-28800000L-86400000L;            //算出昨天的日期
            DateFormat ddf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date(todayZeroDate);
            String yesterday = ddf.format(d);
            List<ReturnJieMotionDataDTO> resultList = new ArrayList<>();
            for (Map.Entry<String, ReturnJieMotionDataDTO[]> entry : oldMotionDataEntityList.entrySet()) {
                ReturnJieMotionDataDTO[] returnJieMotionDataDTOS = entry.getValue();
                for (int a = 0;a < returnJieMotionDataDTOS.length;a++){
                    if (returnJieMotionDataDTOS[a] != null){
                        resultList.add(returnJieMotionDataDTOS[a]);
                    }
                }
                String tableName = entry.getKey().replace(":", "-") + "_"+yesterday;
                receiveDataDao.insertMotionData(resultList,tableName);
            }
        }else if (insertPointer == 1){ //如果当前指针式1，将指针替换为0
            insertPointer = 0;
            long todayZeroDate = (new Date().getTime()/86400000L)*86400000L-28800000L-86400000L;            //算出昨天的日期
            DateFormat ddf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date(todayZeroDate);
            String yesterday = ddf.format(d);
            List<ReturnJieMotionDataDTO> resultList = new ArrayList<>();
            for (Map.Entry<String, ReturnJieMotionDataDTO[]> entry : newMotionDataEntityList.entrySet()) {
                ReturnJieMotionDataDTO[] returnJieMotionDataDTOS = entry.getValue();
                for (int a = 0;a < returnJieMotionDataDTOS.length;a++){
                    if (returnJieMotionDataDTOS[a] != null){
                        resultList.add(returnJieMotionDataDTOS[a]);
                    }
                }
                String tableName = entry.getKey().replace(":", "-") + "_"+yesterday;
                receiveDataDao.insertMotionData(resultList,tableName);
            }
        }
        //获取当前日期，并创建新的数据库表
        long todayZeroDate = (new Date().getTime()/86400000L)*86400000L-28800000L;            //算出昨天的日期
        DateFormat ddf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date(todayZeroDate);
        String today = ddf.format(d);
        List<String> strings = receiveDataDao.selectEquipmentMac();
        for (String str:strings) {
            String newNumber =  str.replace(":", "-");
            receiveDataDao.newBuildTab("motiondata_"+newNumber+"_"+today);
        }
        return 0;
    }

    @Override
    public List<RelayMacListDTO> getRelayMacList(RelayMac relayMac) {
        return receiveDataDao.getRelayMacList(relayMac);
    }


    private int insertMemoryMotionData(MotionDataEntity motionDataEntity){
        List<MotionDataEntity> motionDataEntities = listMap.get(motionDataEntity.getMac());
        long todayZeroDate = (new Date().getTime()/86400000L)*86400000L-28800000L;
        long dateUnix = motionDataEntity.getUnixdate()/1000L - todayZeroDate/1000L;		//获取今天unix时间/秒数
        motionDataEntity.setArrindex(dateUnix);			//设置motionDataEntity中的insertTime属性为当前unix时间
        motionDataEntities.add(motionDataEntity);
        if (insertPointer == 0){            //指针等于0则数据像old的数组插数据
            if (listMap.get(motionDataEntity.getMac()).size() == 3){
                if (oldMotionDataEntityList.get(motionDataEntity.getMac()) == null){
                    ReturnJieMotionDataDTO[] arr = new ReturnJieMotionDataDTO[86400];
                    oldMotionDataEntityList.put(motionDataEntity.getMac(),arr);
                    ReturnJieMotionDataDTO[] arras = oldMotionDataEntityList.get(motionDataEntity.getMac());
                    arras[(int)motionDataEntity.getArrindex()] = returnFenMotionData(motionDataEntities);
                    motionDataEntities.clear();
                }else if (oldMotionDataEntityList.get(motionDataEntity.getMac()) != null){
                    ReturnJieMotionDataDTO[] arrs = oldMotionDataEntityList.get(motionDataEntity.getMac());
                    arrs[(int)motionDataEntity.getArrindex()] = returnFenMotionData(motionDataEntities);
                    motionDataEntities.clear();
                }
            }
        }else if (insertPointer == 1){          //指针等于1则数据像new的数组插数据
            if (listMap.get(motionDataEntity.getMac()).size() == 3){
                if (newMotionDataEntityList.get(motionDataEntity.getMac()) == null){
                    ReturnJieMotionDataDTO[] arr = new ReturnJieMotionDataDTO[86400];
                    newMotionDataEntityList.put(motionDataEntity.getMac(),arr);
                    ReturnJieMotionDataDTO[] arras = newMotionDataEntityList.get(motionDataEntity.getMac());
                    arras[(int)motionDataEntity.getArrindex()] = returnFenMotionData(motionDataEntities);
                    motionDataEntities.clear();
                }else if (newMotionDataEntityList.get(motionDataEntity.getMac()) != null){
                    ReturnJieMotionDataDTO[] arrs = newMotionDataEntityList.get(motionDataEntity.getMac());
                    arrs[(int)motionDataEntity.getArrindex()] = returnFenMotionData(motionDataEntities);
                    motionDataEntities.clear();
                }
            }
        }
        return 1;
    }

    private ReturnJieMotionDataDTO returnFenMotionData(List<MotionDataEntity> motionDataEntities){
        ReturnJieMotionDataDTO returnJieMotionDataDTO = new ReturnJieMotionDataDTO();
        returnJieMotionDataDTO.setMac(motionDataEntities.get(0).getMac());
        returnJieMotionDataDTO.setArrindex(motionDataEntities.get(2).getArrindex());
        returnJieMotionDataDTO.setReceiveTime1(motionDataEntities.get(0).getUnixdate());
        returnJieMotionDataDTO.setMotionData1(motionDataEntities.get(0).getData());
        returnJieMotionDataDTO.setReceiveTime2(motionDataEntities.get(1).getUnixdate());
        returnJieMotionDataDTO.setMotionData2(motionDataEntities.get(1).getData());
        returnJieMotionDataDTO.setReceiveTime3(motionDataEntities.get(2).getUnixdate());
        returnJieMotionDataDTO.setMotionData3(motionDataEntities.get(2).getData());
        return returnJieMotionDataDTO;
    }


    private List<ReturnJieMotionDataDTO> queryMemory(long startZeroDate,long endZeroDate,long todayZeroDate,long startIndex,long endIndex,String mac){
        List<ReturnJieMotionDataDTO> motionDataEntities = new ArrayList<>();
        for (long a = startIndex; a <= endIndex;a++){
            if (insertPointer == 0) {
                if (oldMotionDataEntityList.get(mac) == null){
                    return null;
                }
                if (oldMotionDataEntityList.get(mac)[(int)a] != null){
                    motionDataEntities.add(oldMotionDataEntityList.get(mac)[(int)a]);
                }
            }else if (insertPointer == 1){
                if (oldMotionDataEntityList.get(mac) == null){
                    return null;
                }
                if (newMotionDataEntityList.get(mac)[(int)a] != null){
                    motionDataEntities.add(newMotionDataEntityList.get(mac)[(int)a]);
                }
            }
        }
        return motionDataEntities;
    }

    //查询DB
    private List<ReturnJieMotionDataDTO> queryDB(long startZeroDate,long endZeroDate,long todayZeroDate,long startIndex,long endIndex,String mac){
        DateFormat ddf = new SimpleDateFormat("yyyy-MM-dd");
        QueryDataCriteria queryDataCriteria1 = new QueryDataCriteria();         //添加需要查询的第一个表
        queryDataCriteria1.setMac(mac);
        if (startZeroDate == endZeroDate){
            Date d = new Date(startZeroDate);
            String newNumber =  mac.replace(":", "-");
            queryDataCriteria1.setDateTimeStr(newNumber + "_" + ddf.format(d));           //格式化开始查询时间。分析为查询的表名
            queryDataCriteria1.setStartDate(startIndex);
            queryDataCriteria1.setEndDate(endIndex);
            List<ReturnJieMotionDataDTO> returnMotionDataEntity = receiveDataDao.queryDataCriteria(queryDataCriteria1);
            return returnMotionDataEntity;
        }
        List<ReturnJieMotionDataDTO> motionDataEntities = new ArrayList<>();
        for (long a = startZeroDate;a <= endZeroDate;a+=86400000L){
            Date d = new Date(a);
            String newNumber =  mac.replace(":", "-");
            queryDataCriteria1.setDateTimeStr(newNumber+ "_" + ddf.format(d));           //格式化开始查询时间。分析为查询的表名
            if (a == startZeroDate){
                queryDataCriteria1.setStartDate(startIndex);
                queryDataCriteria1.setEndDate(86400);
                List<ReturnJieMotionDataDTO> returnMotionDataEntity = receiveDataDao.queryDataCriteria(queryDataCriteria1);
                motionDataEntities.addAll(returnMotionDataEntity);
            }
            if (a == endZeroDate && endZeroDate != todayZeroDate){      //判断是否是最后一次循环，并且结束查询时间和今天时间必须不相同
                queryDataCriteria1.setStartDate(0);
                queryDataCriteria1.setEndDate(endIndex);
                List<ReturnJieMotionDataDTO> returnMotionDataEntity = receiveDataDao.queryDataCriteria(queryDataCriteria1);
                motionDataEntities.addAll(returnMotionDataEntity);
                return motionDataEntities;
            }
            if (a+86400000L != todayZeroDate){
                queryDataCriteria1.setStartDate(0);
                queryDataCriteria1.setEndDate(86400);
                List<ReturnJieMotionDataDTO> returnMotionDataEntity = receiveDataDao.queryDataCriteria(queryDataCriteria1);
                motionDataEntities.addAll(returnMotionDataEntity);
            }
        }
        return motionDataEntities;
    }




    //解析完成后调用（正确解析xy轴数）
    private static  List<float[]> ByteToValue(String src) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] data = base64Decoder.decodeBuffer(src);
        List<float[]> bytesList = new ArrayList<>();
        for (int numberLian = 0; numberLian < 6; numberLian++){
            if ( numberLian == 0){
                float axArray[] = ByteToValueData(data,0);
                bytesList.add(axArray);
            }else if (numberLian == 1){
                float ayArray[] = ByteToValueData(data,2);
                bytesList.add(ayArray);
            }else if (numberLian == 2){
                float azArray[] = ByteToValueData(data,4);
                bytesList.add(azArray);
            }else if (numberLian == 3){
                float gxArray[] = ByteToValueData(data,6);
                bytesList.add(gxArray);
            }else if (numberLian == 4){
                float gyArray[] = ByteToValueData(data,8);
                bytesList.add(gyArray);
            }else if (numberLian == 5){
                float gzArray[] = ByteToValueData(data,10);
                bytesList.add(gzArray);
            }
        }
        return bytesList;
    }

    //byte解析方法
    private static float[] ByteToValueData(byte[] data,int forNumebr){
        float dataArray[] = new float[16];
        int arrayOneNumber = forNumebr;
        int arrayTwoNumber = forNumebr + 1;
        if (forNumebr < 6){
            for (int as = 0; as < 16 ;as++){
                dataArray[as] = byteArrayToInt(data[arrayOneNumber],data[arrayTwoNumber])/2048f;
                arrayOneNumber = arrayOneNumber + 12;
                arrayTwoNumber = arrayTwoNumber + 12;
                if (as == 16){
                    arrayOneNumber = 0;
                    arrayTwoNumber = 0;
                }
            }
        }else {
            for (int as = 0; as < 16 ;as++){
                dataArray[as] = byteArrayToInt(data[arrayOneNumber],data[arrayTwoNumber])/ 16.4f;
                arrayOneNumber = arrayOneNumber + 12;
                arrayTwoNumber = arrayTwoNumber + 12;
                if (as == 16){
                    arrayOneNumber = 0;
                    arrayTwoNumber = 0;
                }
            }
        }
        return dataArray;
    }


    public static int byteArrayToInt(byte byte1,byte byte2) {
        return (byte2 << 8) | (byte1 & 0xFF);
    }

}
