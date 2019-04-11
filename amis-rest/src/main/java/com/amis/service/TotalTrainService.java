package com.amis.service;

import com.amis.common.ResponseVO;
import com.amis.entity.TotalTrain;



/**
 * @InterfaceName TotalTrainService
 * @Description 训练
 * @Author chenzexin
 * @Date 2019/3/12 20:37
 **/
public interface TotalTrainService {
    ResponseVO insertTrain(TotalTrain totalTrain);

    ResponseVO insertTrainAlone(TotalTrain totalTrain);

    ResponseVO insertStudentTrainAlone(TotalTrain totalTrain);
}
