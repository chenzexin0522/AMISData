package com.amis.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName StudentTrain
 * @Description 学生训练实体
 * @Author chenzexin
 * @Date 2019/3/13 9:57
 **/
@Data
public class StudentTrain {

    private int st_id;
    private String start_end_time;      //开始即结束时间
    private String train_duration;      //目标训练时长
    private int tt_id;                  //教练训练表id
    private int u_id;                   //教练id

    private List<ActionValue> actionValue;    //动作值实体类
    private List<TrainDetailed> trainDetailed; //详细信息实体类

}
