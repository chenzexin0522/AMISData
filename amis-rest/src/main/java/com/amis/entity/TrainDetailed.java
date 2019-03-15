package com.amis.entity;

import lombok.Data;

/**
 * @ClassName TrainDetailed
 * @Description 学生训练详细数据
 * @Author chenzexin
 * @Date 2019/3/13 17:26
 **/
@Data
public class TrainDetailed {

    private int std_id;
    private String std_speed;       //速度
    private String std_frequency;   //频率
    private String std_Melody;      //旋转
    private String std_Fluency;     //流畅度
    private String std_Power;       //力量
    private int at_id;
    private int st_id;
}
