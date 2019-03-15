package com.amis.dao;

import com.amis.entity.ActionValue;
import com.amis.entity.StudentTrain;
import com.amis.entity.TotalTrain;
import com.amis.entity.TrainDetailed;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName TotalTrainDao
 * @Description 训练
 * @Author chenzexin
 * @Date 2019/3/12 20:45
 **/
@Mapper
public interface TotalTrainDao {
    int insertTrain(TotalTrain totalTrain);

    int insertAV(ActionValue actionValue);

    int insertStudentTrain(StudentTrain studentTrain);

    int insertStudentTrainAV(StudentTrain studentTrain);

    int insertDetailed(StudentTrain studentTrain);

    int insertTrainDetailed(TrainDetailed trainDetailed);
}
