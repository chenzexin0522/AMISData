package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName StudentTrainTotalList
 * @Description 学生个人训练
 * @Author chenzexin
 * @Date 2019/5/20 10:52
 **/
@Data
public class StudentTrainTotalList {
    private String start_time;      //训练开始时间
    private String end_time;        //训练结束时间
    private String action_one_rate;     //动作1完成率
    private String action_two_rate;     //动作2完成率
    private String action_three_rate;     //动作3完成率
    private String action_four_rate;     //动作4完成率
    private String action_total_rate;   //平均完成率
    private String action_set_one;      //动作1设置值
    private String action_set_two;      //动作2设置值
    private String action_set_three;    //动作3设置值
    private String action_set_four;     //动作4设置值
    private String action_actual_one;   //动作1完成值
    private String action_actual_two;   //动作2完成值
    private String action_actual_three; //动作3完成值
    private String action_actual_four;  //动作4完成值

    private String action_one_speed;    //动作1-速度
    private String action_one_frequency;//动作1-频率
    private String action_one_melody;   //动作1-旋转
    private String action_one_fluency;  //动作1-流畅度
    private String action_one_power;    //动作1-力量

    private String action_two_speed;    //动作2-速度
    private String action_two_frequency;//动作2-频率
    private String action_two_melody;   //动作2-旋转
    private String action_two_fluency;  //动作2-流畅度
    private String action_two_power;    //动作2-力量

    private String action_three_speed;    //动作3-速度
    private String action_three_frequency;//动作3-频率
    private String action_three_melody;   //动作3-旋转
    private String action_three_fluency;  //动作3-流畅度
    private String action_three_power;    //动作3-力量

    private String action_four_speed;    //动作4-速度
    private String action_four_frequency;//动作4-频率
    private String action_four_melody;   //动作4-旋转
    private String action_four_fluency;  //动作4-流畅度
    private String action_four_power;    //动作4-力量


}
