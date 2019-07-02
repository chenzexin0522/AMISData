package com.amis.entity;

import lombok.Data;

/**
 * @ClassName TabResult
 * @Description 结果表实体
 * @Author chenzexin
 * @Date 2019/4/5 17:47
 **/
@Data
public class TabResult {
    private int tr_id;                      //结果表id
    private int tc_id;                      //班级id
    private int te_id;                      //设备id
    private int uc_id;                      //学生id
    private int tt_id;                      //训练表id
    private int mt_type;                    //运动类型分类
    private int action_actual_one;          //动作实际完成值
    private int action_actual_two;
    private int action_actual_three;
    private int action_actual_four;
    private String action_one_speed;        //动作速度
    private String action_one_frequency;    //动作频率
    private String action_one_melody;       //动作旋转
    private String action_one_fluency;      //动作流畅度
    private String action_one_power;        //动作力量
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
