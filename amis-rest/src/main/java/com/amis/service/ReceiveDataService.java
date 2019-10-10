package com.amis.service;

import com.amis.common.ResponseVO;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;
import com.amis.entity.RelayMac;
import com.amis.entity.dto.RelayMacListDTO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @InterfaceName ReceiveDataService
 * @Description 接收数据
 * @Author chenzexin
 * @Date 2019/8/9 10:38
 **/
public interface ReceiveDataService {
    ResponseVO insertMotionData(MotionDataEntity motionDataEntity) throws IOException, ParseException;

    String getListSize();

    Future<ResponseVO> queryDataCriteria(QueryDataCriteria queryDataCriteria) throws ParseException, IOException;

    int newBuildTab();

    List<RelayMacListDTO> getRelayMacList(RelayMac relayMac);

}
