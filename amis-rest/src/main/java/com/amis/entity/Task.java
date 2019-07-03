package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Task
 * @Description 作业实体类
 * @Author chenzexin
 * @Date 2019/4/8 17:11
 **/
@Data
public class Task {
    private int ta_id;
    private int tc_id;
    private int u_id;
    private String start_time;
    private String end_time;
    private String tab_task;
    private int action_set_one;
    private int action_set_two;
    private int action_set_three;
    private int action_set_four;
    private int state;
}
