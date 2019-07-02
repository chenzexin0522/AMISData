package com.amis.dao;

import com.amis.entity.TabResult;
import com.amis.entity.TotalTrain;
import com.amis.entity.dto.InertTabResultList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @InterfaceName TotalTrainDao
 * @Description 训练
 * @Author chenzexin
 * @Date 2019/3/12 20:45
 **/
@Mapper
public interface TotalTrainDao {
    int insertTrain(TotalTrain totalTrain);//插入结果集合

    int insertTabResultList( InertTabResultList inertTabResultList);

    void updateTrainType(TotalTrain totalTrain);

    int updateTrainAlone(TotalTrain totalTrain);

    int deleteTrain(@Param("tt_id")int tt_id, @Param("tab_total_train") String tab_total_train);
}
