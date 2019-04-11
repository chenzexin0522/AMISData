package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName StudentTrainTab
 * @Description 学生训练详情
 * @Author chenzexin
 * @Date 2019/4/6 21:28
 **/
@Data
public class StudentTrainTab {

    private int total_comletion_rate;     //所有动作平均值

    private int one_completion_rate;        //动作1完成率
    private int two_completion_rate;
    private int three_completion_rate;
    private int four_completion_rate;

    private String action_one_speed;        //动作1速度
    private String action_one_frequency;    //动作1频率
    private String action_one_melody;       //动作1旋转
    private String action_one_fluency;      //动作1流畅
    private String action_one_power;        //动作1力量
    private String action_two_speed;
    private String action_two_frequency;
    private String action_two_melody;
    private String action_two_fluency;
    private String action_two_power;
    private String action_three_speed;
    private String action_three_frequency;
    private String action_three_melody;
    private String action_three_fluency;
    private String action_three_power;
    private String action_four_speed;
    private String action_four_frequency;
    private String action_four_melody;
    private String action_four_fluency;
    private String action_four_power;



}
