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
    private String start_time;
    private String end_time;
    private int tc_uc_id;
    private int type;
    private int u_id;
}
