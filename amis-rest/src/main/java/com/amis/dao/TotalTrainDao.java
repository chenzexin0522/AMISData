package com.amis.dao;

import com.amis.entity.TabResult;
import com.amis.entity.TotalTrain;
import org.apache.ibatis.annotations.Mapper;

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

    int insertTabResultList(List<TabResult> tabResultsList);

    void updateTrainType(TotalTrain totalTrain);

    int updateTrainAlone(TotalTrain totalTrain);

    int deleteTrain(int tt_id);
}
