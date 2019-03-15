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

    @RequestMapping(value = "insertTrain",method = RequestMethod.POST)
    public ResponseVO insertTrain(@RequestBody TotalTrain totalTrain) throws Exception {    //判断是否为空
        if (totalTrain == null || StringUtils.isBlank(totalTrain.getStart_end_time())
                || StringUtils.isBlank(totalTrain.getTrain_duration())){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ResponseVO responseVO = totalTrainService.insertTrain(totalTrain);
        return responseVO;
    }
}
