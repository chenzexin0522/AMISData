package com.amis.entity;

import lombok.Data;

import java.util.List;


/**
 * @ClassName TotalTrain
 * @Description 总训练表实体
 * @Author chenzexin
 * @Date 2019/3/12 18:22
 **/
@Data
public class TotalTrain {

    private int tt_id;
    private String start_end_time;      //开始即结束时间
    private int total_number;           //总参加人数
    private int actual_number;          //实际完成人数
    private String average_number;      //平均完成率
    private String train_duration;      //目标训练时长
    private int u_id;                   //用户id
    private List<ActionValue> actionValue;    //动作值实体类
 //   private StudentTrainDTO student;       //学生实体类
    private List<StudentTrain> student;
}
