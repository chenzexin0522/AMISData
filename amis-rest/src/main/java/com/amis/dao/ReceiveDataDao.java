package com.amis.dao;

import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;
import com.amis.entity.dto.MotionDataEntityDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName ReceiveDataDao
 * @Description 接收数据DAO
 * @Author chenzexin
 * @Date 2019/8/9 10:42
 **/

@Mapper
public interface ReceiveDataDao {
    int insertMotionData( @Param("motionDataEntityList") List<MotionDataEntity> motionDataEntityList);

    List<MotionDataEntityDTO> queryDataCriteria(QueryDataCriteria queryDataCriteria);

    int newBuildTab(@Param("crtDate") String crtDate);
}
