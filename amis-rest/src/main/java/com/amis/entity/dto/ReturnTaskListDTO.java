package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnTaskListDTO
 * @Description 作业列表DTO
 * @Author chenzexin
 * @Date 2019/4/8 18:56
 **/
@Data
public class ReturnTaskListDTO {
    private int ta_id;
    private String tc_name;
    private String start_time;
    private int dayNumber;
    private int action_set_one;
    private int action_set_two;
    private int action_set_three;
    private int action_set_four;
    private int completion_number;
    private int completion_rate;
}
