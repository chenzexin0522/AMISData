package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName StudentTrainList
 * @Description 学生训练列表
 * @Author chenzexin
 * @Date 2019/4/6 19:53
 **/
@Data
public class StudentTrainList {
    private int tr_id;
    private String uc_name;
    private int action_actual_one;      //实际完成值
    private int action_actual_two;
    private int action_actual_three;
    private int action_actual_four;


}
