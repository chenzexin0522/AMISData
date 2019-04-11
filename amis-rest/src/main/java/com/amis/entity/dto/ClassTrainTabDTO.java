package com.amis.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ClassTrainTabDTO
 * @Description 班级训练表单
 * @Author chenzexin
 * @Date 2019/4/6 17:51
 **/
@Data
public class ClassTrainTabDTO {
    private int join_number;        //参加人数
    private int actual_number;      //实际完成人数
    private int total_completion_rate;    //人数完成率
    private int action_set_one;     //动作设置值
    private int action_set_two;
    private int action_set_three;
    private int action_set_four;
    private int time_difference;
    private int one_completion_rate; //动作1完成率
    private int two_completion_rate; //动作2完成率
    private int three_completion_rate; //动作3完成率
    private int four_completion_rate; //动作4完成率
    private List<StudentTrainList> studentTrainLists;  //学生集合

}
