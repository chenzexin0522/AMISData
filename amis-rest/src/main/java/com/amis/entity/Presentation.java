package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Presentation
 * @Description 报告实体类
 * @Author chenzexin
 * @Date 2019/4/6 22:22
 **/
@Data
public class Presentation {
    private int pr_id;
    private String insert_time;         //插入时间
    private String start_time;          //查询--开始时间
    private String end_time;            //查询--结束时间
    private String tab_presentation;
    private String opn;
    private String tab_total_train;
    private String tab_result;
    private int tc_uc_id;
    private int type;
    private int u_id;
    private int mt_type;                //运动类型-默认:篮球，1.羽毛球
}
