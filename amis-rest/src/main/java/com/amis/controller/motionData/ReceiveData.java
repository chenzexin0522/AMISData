package com.amis.controller.motionData;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;
import com.amis.entity.RelayMac;
import com.amis.entity.dto.RelayMacListDTO;
import com.amis.service.ReceiveDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName ReceiveDataService
 * @Description 接收数据
 * @Author chenzexin
 * @Date 2019/8/9 10:34
 **/

@RestController
@RequestMapping(value = "sprData")
public class ReceiveData {

    private static int ao = 0;

    @Autowired
    private ReceiveDataService receiveDataService;



    /**
     * @Author chenzexin
     * @Date 2019/8/12 10:13
     * @param relayMac
     * @return com.amis.common.ResponseVO
     * @Description        获取指定中继下的设备
     **/
    @RequestMapping(value = "getRelayMac",method = RequestMethod.POST)
    public ResponseVO getRelayMac(@RequestBody RelayMac relayMac) {
        List<RelayMacListDTO> relayMacListDTOS = receiveDataService.getRelayMacList(relayMac);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(relayMacListDTOS);
        return responseVO;
    }



    /**
     * @Author chenzexin
     * @Date 2019/8/12 10:04
     * @param queryDataCriteria
     * @return com.amis.common.ResponseVO
     * @Description        查询指定设备时间范围内的数据
     **/
    @RequestMapping(value = "queryDataCriteria",method = RequestMethod.POST)//@RequestBody QueryDataCriteria queryDataCriteria
    @ResponseBody
    public ResponseVO queryDataCriteria(@RequestParam String mac, @RequestParam String startDate, @RequestParam String endDate, @RequestParam Integer analysisType) throws AmisException, ParseException, IOException, ExecutionException, InterruptedException {
        if (StringUtils.isBlank(String.valueOf(mac))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        QueryDataCriteria queryDataCriteria = new QueryDataCriteria();
        queryDataCriteria.setMac(mac);
        queryDataCriteria.setStartDate(Long.valueOf(startDate));
        queryDataCriteria.setEndDate(Long.valueOf(endDate));
        queryDataCriteria.setAnalysisType(analysisType);
        Future<ResponseVO> future = receiveDataService.queryDataCriteria(queryDataCriteria);
        return future.get();
    }

    /**
     * @Author chenzexin
     * @Date 2019/8/12 10:04
     * @param queryDataCriteria
     * @return com.amis.common.ResponseVO
     * @Description        查询suoyou设备时间范围内的数据
     **/
    @RequestMapping(value = "queryWholeDataCriteria",method = RequestMethod.POST)//@RequestBody QueryDataCriteria queryDataCriteria
    @ResponseBody
    public ResponseVO queryWholeDataCriteria(@RequestParam String startDate, @RequestParam String endDate, @RequestParam Integer analysisType) throws AmisException, ParseException, IOException, ExecutionException, InterruptedException {
        if (StringUtils.isBlank(String.valueOf(startDate))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        QueryDataCriteria queryDataCriteria = new QueryDataCriteria();
        queryDataCriteria.setStartDate(Long.valueOf(startDate));
        queryDataCriteria.setEndDate(Long.valueOf(endDate));
        queryDataCriteria.setAnalysisType(analysisType);
        Future<ResponseVO> future = receiveDataService.queryWholeDataCriteria(queryDataCriteria);
        return future.get();
    }


    /**
     * @Author chenzexin
     * @Date 2019/8/12 10:04
     * @param queryDataCriteria
     * @return com.amis.common.ResponseVO
     * @Description        查询指定设备时间范围内的数据（页面请求）
     **/
    @RequestMapping(value = "queryDataCriteriaWebView",method = RequestMethod.POST)
    public ResponseVO queryDataCriteriaWebView(QueryDataCriteria queryDataCriteria) throws AmisException, ParseException, IOException, ExecutionException, InterruptedException {
        if (StringUtils.isBlank(String.valueOf(queryDataCriteria.getMac()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        Future<ResponseVO> future = receiveDataService.queryDataCriteria(queryDataCriteria);
        return future.get();
    }



    /**
     * @Author chenzexin
     * @Date 2019/8/12 10:04
     * @param motionDataEntity
     * @return com.amis.common.ResponseVO
     * @Description        接收192位字节接口
     *      解：每秒钟3个包，有一个只存储3个包的mapList，定义此mapList是为了实时将最新的数据让web进行显示以及3个包整合成一个包进行处理。
     *          如果mapList中某个key的value的size超过3，则将数据转移到arr[86400]数组中。
     **/
    @RequestMapping(value = "receiveData",method = RequestMethod.POST)
    public ResponseVO insertMotionData(@RequestBody MotionDataEntity motionDataEntity) throws AmisException, IOException, ParseException {
        if (StringUtils.isBlank(String.valueOf(motionDataEntity.getData()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return receiveDataService.insertMotionData(motionDataEntity);
    }


    /**
     * @Author chenzexin
     * @Date 2019/8/12 10:13
     * @param motionDataEntity
     * @return com.amis.common.ResponseVO
     * @Description        获取接收次数以及存储个数
     **/
    @RequestMapping(value = "getao",method = RequestMethod.POST)
    public ResponseVO getao(@RequestBody MotionDataEntity motionDataEntity) throws AmisException {
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setId(ao);
        responseVO.setData(receiveDataService.getListSize());
        ao=0;
        return responseVO;
    }


}
