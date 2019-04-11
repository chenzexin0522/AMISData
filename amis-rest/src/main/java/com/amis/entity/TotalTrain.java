package com.amis.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * @ClassName TotalTrain
 * @Description 训练表实体
 * @Author chenzexin
 * @Date 2019/3/12 18:22
 **/
@Data
public class TotalTrain {

    private int tr_id;
    private int tt_id;
    private String start_time;              //开始时间
    private String end_time;               //结束时间
    private int train_duration;      //目标训练时长
    private int u_id;                   //用户id
    private int tc_id;                  //班级id
    private String action_set_one;         //动作设置值
    private String action_set_two;
    private String action_set_three;
    private String action_set_four;
    private int train_state;
    private int avg_duration;
    private List<TabResult> tabResultsList; //结果表集合

}
