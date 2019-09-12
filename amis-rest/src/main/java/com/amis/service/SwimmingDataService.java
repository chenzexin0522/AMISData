package com.amis.service;


import com.amis.entity.MotionDataEntity;
import com.amis.entity.dto.ReturnSwimmingDataDTO;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName SwimmingDataService
 * @Description
 * @Author chenzexin
 * @Date 2019/9/10 18:51
 **/
public interface SwimmingDataService {
    int insertSwimmingData(MotionDataEntity motionDataEntity);

    List<MotionDataEntity> getSwimmingDataExcel();

    List<ReturnSwimmingDataDTO> analysisMotionDataEntity(List<MotionDataEntity> rows) throws IOException;

    void truncateTable();
}
