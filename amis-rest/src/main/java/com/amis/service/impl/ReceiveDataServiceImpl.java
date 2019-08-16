package com.amis.service.impl;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.dao.ReceiveDataDao;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;
import com.amis.entity.dto.MotionDataEntityDTO;
import com.amis.service.ReceiveDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ReceiveDataServiceImpl
 * @Description 接收数据
 * @Author chenzexin
 * @Date 2019/8/9 10:38
 **/

@Service
public class ReceiveDataServiceImpl implements ReceiveDataService {

    private static List<MotionDataEntity> motionDataEntityList = new ArrayList<>();

    public static List<float[]> dataListStatic ;

    @Autowired
    private ReceiveDataDao receiveDataDao;




    @Override
    public ResponseVO insertMotionData(MotionDataEntity motionDataEntity) throws IOException {
        int ysAno = 0;
        String str = "KP+3/xAI+f8BAAMAKf+4/wAIAgAPAAUAJf+7/wQIAAACAAMAJP+6//kHAAAEAAMAHf+5/wEIAQD2\n" +
                "/wIAI/+4//4H/f/z/wAAJ/+7/wMIAwAGAAMAJf+5/wMI+////wIAIv+9/wgI/v8EAAMAJv+4//cH\n" +
                "AgD//wUAIP+6/xII/f/5/wAAIv+3//4H+//8/wIAJP+7/wcIAQAHAAQAIf+4/wUI+P/4/wIALP+5\n" +
                "//8HAgAJAAQAH/+2/wwI//8BAAMA)";
        List<float[]> dataArray = ByteToValue(motionDataEntity.getData());      //将中继传递的string解析
        dataListStatic = dataArray;                                             //将解析后的结果赋值给临时集合LIST，供web显示用
        analysisStrData(dataArray);                                             //将解析后的结果分解成对象放入全局LIST，供存数据库使用
       if (motionDataEntityList.size() == 10000){         //判断
           ysAno = receiveDataDao.insertMotionData(motionDataEntityList);
           motionDataEntityList.clear();
           if (ysAno == 0){
               ResponseVO responseVO = new ResponseVO(MessageKey.INSERT_FAIL);
           }
       }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    @Override
    public String getListSize() {
        return String.valueOf(motionDataEntityList.size());
    }

    @Override
    public ResponseVO queryDataCriteria(QueryDataCriteria queryDataCriteria) {
        List<MotionDataEntityDTO> motionDataEntityDTOS = receiveDataDao.queryDataCriteria(queryDataCriteria);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(motionDataEntityDTOS);
        return responseVO;
    }

    @Override
    public int newBuildTab(String crtDate) {
        //获取当前日期，并创建新的数据库表
            SimpleDateFormat dates = new SimpleDateFormat("yyyy_MM_dd");
            String formats = dates.format(new Date(System.currentTimeMillis()));
        return receiveDataDao.newBuildTab(formats+"motionData");
    }



    private static  int analysisStrData(List<float[]> srcFloatList){
        for (int as = 0; as < srcFloatList.get(0).length; as++){
            MotionDataEntity motionDataEntity = new MotionDataEntity();
            motionDataEntity.setAx(Float.toString( srcFloatList.get(0)[as]));
            motionDataEntity.setAy(Float.toString( srcFloatList.get(1)[as]));
            motionDataEntity.setAz(Float.toString( srcFloatList.get(2)[as]));
            motionDataEntity.setGx(Float.toString( srcFloatList.get(3)[as]));
            motionDataEntity.setGy(Float.toString( srcFloatList.get(4)[as]));
            motionDataEntity.setGz(Float.toString( srcFloatList.get(5)[as]));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            String format = date.format(new Date(System.currentTimeMillis()));
            motionDataEntity.setReceiveTime(format);
            motionDataEntityList.add(motionDataEntity);
        }
        return 1;
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
