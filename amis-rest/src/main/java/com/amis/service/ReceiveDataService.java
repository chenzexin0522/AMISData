package com.amis.service;

import com.amis.common.ResponseVO;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;

import java.io.IOException;

/**
 * @InterfaceName ReceiveDataService
 * @Description 接收数据
 * @Author chenzexin
 * @Date 2019/8/9 10:38
 **/
public interface ReceiveDataService {
    ResponseVO insertMotionData(MotionDataEntity motionDataEntity) throws IOException;

    String getListSize();

    ResponseVO queryDataCriteria(QueryDataCriteria queryDataCriteria);

    int newBuildTab(String crtDate);

}
