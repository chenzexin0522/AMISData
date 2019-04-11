package com.amis.controller.train;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.TotalTrain;
import com.amis.service.TotalTrainService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName TotalTrainController
 * @Description 训练
 * @Author chenzexin
 * @Date 2019/3/12 20:36
 **/
@RestController
@RequestMapping(value = "train")
public class TotalTrainController {

    @Autowired
    private TotalTrainService totalTrainService;

    /**
     * @Author chenzexin
     * @Date 2019/4/8 14:54
     * @param totalTrain
     * @return com.amis.common.ResponseVO
     * @Description        插入训练表单加结果表单
     **/
    @RequestMapping(value = "insertTrain",method = RequestMethod.POST)
    public ResponseVO insertTrain(@RequestBody TotalTrain totalTrain) throws Exception {    //判断是否为空
        if (totalTrain == null ){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ResponseVO responseVO = totalTrainService.insertTrain(totalTrain);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/8 14:54
     * @param totalTrain
     * @return com.amis.common.ResponseVO
     * @Description        插入训练表单
     **/
    @RequestMapping(value = "insertTrainAlone",method = RequestMethod.POST)
    public ResponseVO insertTrainAlone(@RequestBody TotalTrain totalTrain) throws Exception {    //判断是否为空
        if (totalTrain == null ){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ResponseVO responseVO = totalTrainService.insertTrainAlone(totalTrain);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/8 14:54
     * @param totalTrain
     * @return com.amis.common.ResponseVO
     * @Description        插入结果表单
     **/
    @RequestMapping(value = "insertStudentTrainAlone",method = RequestMethod.POST)
    public ResponseVO insertStudentTrainAlone(@RequestBody TotalTrain totalTrain) throws Exception {    //判断是否为空
        if (totalTrain == null || StringUtils.isBlank(String.valueOf(totalTrain.getTt_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ResponseVO responseVO = totalTrainService.insertStudentTrainAlone(totalTrain);
        return responseVO;
    }
}
