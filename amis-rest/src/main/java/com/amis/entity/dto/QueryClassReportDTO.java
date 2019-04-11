package com.amis.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName queryClassReportDTO
 * @Description 按时间阶段查询班级训练报告
 * @Author chenzexin
 * @Date 2019/4/3 13:56
 **/
@Data
public class QueryClassReportDTO {
    private int tc_id;
    private int u_id;
    private String start_time;
    private String end_time;
    private int train_number;        //训练次数
    private int train_average;       //训练百分比
    private int type_one_average;              //投篮百分比
    private int type_two_average;              //运球百分比
    private int type_three_average;              //传球百分比
    private int type_four_average;             //上篮百分比
    private List totalList;                 //总训练百分比
    private List type_one_averageList;              //投篮百分比集合
    private List type_two_averageList;              //运球百分比集合
    private List type_three_averageList;              //传球百分比集合
    private List type_four_averageList;             //上篮百分比集合


}
