package com.amis.dao;

import com.amis.entity.MotionDataEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName SwimmingDataDao
 * @Description
 * @Author chenzexin
 * @Date 2019/9/10 18:53
 **/
@Mapper
public interface SwimmingDataDao {
    int insertSwimmingData(MotionDataEntity motionDataEntity);

    List<MotionDataEntity> getSwimmingDataExcel();

    void truncateTable();
}
