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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

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
    @RequestMapping(value = "queryDataCriteria",method = RequestMethod.POST)
    public ResponseVO queryDataCriteria(@RequestBody QueryDataCriteria queryDataCriteria) throws AmisException, ParseException, IOException {
        if (StringUtils.isBlank(String.valueOf(queryDataCriteria.getMac()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return receiveDataService.queryDataCriteria(queryDataCriteria);
    }


    /**
     * @Author chenzexin
     * @Date 2019/8/12 10:04
     * @param queryDataCriteria
     * @return com.amis.common.ResponseVO
     * @Description        查询指定设备时间范围内的数据（页面请求）
     **/
    @RequestMapping(value = "queryDataCriteriaWebView",method = RequestMethod.POST)
    public ResponseVO queryDataCriteriaWebView(QueryDataCriteria queryDataCriteria) throws AmisException, ParseException, IOException {
        if (StringUtils.isBlank(String.valueOf(queryDataCriteria.getMac()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        return receiveDataService.queryDataCriteria(queryDataCriteria);
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
