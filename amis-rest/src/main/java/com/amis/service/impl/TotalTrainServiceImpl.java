package com.amis.service.impl;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.dao.TotalTrainDao;
import com.amis.entity.ActionValue;
import com.amis.entity.StudentTrain;
import com.amis.entity.TotalTrain;
import com.amis.entity.TrainDetailed;
import com.amis.service.TotalTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName TotalTrainServiceImpl
 * @Description 训练
 * @Author chenzexin
 * @Date 2019/3/12 20:38
 **/
@Service
public class TotalTrainServiceImpl implements TotalTrainService {

    @Autowired
    private TotalTrainDao totalTrainDao;

    /**
     * @Author chenzexin
     * @Date 2019/3/13 11:37
     * @param totalTrain
     * @return int
     * @Description        插入总训练信息-插入学生个人训练信息
     **/
    @Override
    public ResponseVO insertTrain(TotalTrain totalTrain) {
        ResponseVO responseVO;
        int bs;
        if (totalTrain == null || totalTrain.getStudent() == null || totalTrain.getActionValue() == null ){
            responseVO=new ResponseVO(MessageKey.PARAMETER_ERROR);  //设置返回值
            return responseVO;
        }
        totalTrainDao.insertTrain(totalTrain);                   //添加总训练表基本信息
            List<ActionValue> actionValue = totalTrain.getActionValue();
            for (ActionValue actionValue1 : actionValue) {       //遍历运动动作集合
                actionValue1.setSt_tt_id(totalTrain.getTt_id());    //指定运动动作对应总训练表id
                actionValue1.setU_id(totalTrain.getU_id());         //指定运动动作表对应用户id
                bs = totalTrainDao.insertAV(actionValue1);       //添加总训练表运动动作详细信息
                if (bs == 0){                                    //判断是否添加失败
                    responseVO=new ResponseVO(MessageKey.INSERT_FAIL);  //设置返回值
                    return responseVO;
                }
            }
            List<StudentTrain> studentTrains = totalTrain.getStudent();
            for (StudentTrain studentTrain : studentTrains) {          //遍历学生训练表基本信息
                studentTrain.setTt_id(totalTrain.getTt_id());          //指定学生训练表对应总训练表id
                bs = totalTrainDao.insertStudentTrain(studentTrain);
                if (bs == 0){
                    responseVO=new ResponseVO(MessageKey.INSERT_FAIL);
                    return responseVO;
                }
                List<ActionValue> actionValues = studentTrain.getActionValue();
                for (ActionValue actionValueT : actionValues) {         //遍历运动动作集合
                    actionValueT.setSt_tt_id(studentTrain.getSt_id());  //指定运动动作对应学生训练表id
                    actionValueT.setU_id(studentTrain.getU_id());       //指定运动动作表对应用户id
                    bs = totalTrainDao.insertAV(actionValueT);  //添加学生训练表运动动作详细信息
                    if (bs == 0){
                        responseVO=new ResponseVO(MessageKey.INSERT_FAIL);
                        return responseVO;
                    }
                }
                List<TrainDetailed> trainDetaileds=studentTrain.getTrainDetailed();
                for (TrainDetailed  trainDetailed: trainDetaileds) {        //遍历学生运动详细数据
                    trainDetailed.setSt_id(studentTrain.getSt_id());        //指定详细运动数据对应学生训练表id
                    bs = totalTrainDao.insertTrainDetailed(trainDetailed);  //添加学生详数据
                    if (bs == 0){
                        responseVO=new ResponseVO(MessageKey.INSERT_FAIL);
                        return responseVO;
                    }
                }

            }
        responseVO=new ResponseVO(MessageKey.RETURN_OK);        //设置返回类型
        return responseVO;
    }
}
