package com.amis.controller.motionData;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;
import com.amis.service.ReceiveDataService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
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
     * @Date 2019/8/12 10:04
     * @param queryDataCriteria
     * @return com.amis.common.ResponseVO
     * @Description        查询指定设备时间范围内的数据
     **/
    @RequestMapping(value = "queryDataCriteria",method = RequestMethod.POST)
    public ResponseVO queryDataCriteria(@RequestBody QueryDataCriteria queryDataCriteria) throws AmisException {
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
     **/
    @RequestMapping(value = "receiveData",method = RequestMethod.POST)
    public ResponseVO insertMotionData(@RequestBody MotionDataEntity motionDataEntity) throws AmisException, IOException {
        if (StringUtils.isBlank(String.valueOf(motionDataEntity.getData()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ao++;
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
