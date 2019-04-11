package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnTotalList
 * @Description 返回训练列表
 * @Author chenzexin
 * @Date 2019/4/6 15:03
 **/
@Data
public class ReturnTotalList {
    private int tt_id;
    private String start_time;
    private String end_time;
    private String train_duration;
    private String tc_name;
    private int total_one;
    private int total_two;
    private int total_three;
    private int total_four;
}
