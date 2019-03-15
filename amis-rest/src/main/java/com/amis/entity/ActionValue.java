package com.amis.entity;

import lombok.Data;

/**
 * @ClassName ActionValue
 * @Description 动作值表
 * @Author chenzexin
 * @Date 2019/3/13 16:00
 **/
@Data
public class ActionValue {

    private int av_id;
    private String av_set;
    private String av_yes;
    private String av_average;
    private int at_id;
    private int st_tt_id;
    private int u_id;
}
