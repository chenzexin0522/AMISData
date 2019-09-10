package com.amis.dao;

import com.amis.entity.MotionDataEntity;
import com.amis.entity.QueryDataCriteria;
import com.amis.entity.RelayMac;
import com.amis.entity.dto.MotionDataEntityDTO;
import com.amis.entity.dto.RelayMacListDTO;
import com.amis.entity.dto.ReturnJieMotionDataDTO;
import com.amis.entity.dto.ReturnMotionDataDTO;
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
    int insertMotionData( @Param("returnJieMotionDataDTOS") List<ReturnJieMotionDataDTO> returnJieMotionDataDTOS, @Param("tableName")String tabName);

    List<ReturnJieMotionDataDTO> queryDataCriteria(QueryDataCriteria queryDataCriteria);

    int newBuildTab(@Param("crtDate") String crtDate);

    List<RelayMacListDTO> getRelayMacList(RelayMac relayMac);

    List<MotionDataEntity> queryWholeDataCriteria(QueryDataCriteria queryDataCriteria1);

    List<String> selectEquipmentMac();
}
