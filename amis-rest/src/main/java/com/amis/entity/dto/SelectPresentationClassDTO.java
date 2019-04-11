package com.amis.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName SelectPresentationClassDTO
 * @Description 查询报告实体类
 * @Author chenzexin
 * @Date 2019/4/8 10:47
 **/
@Data
public class SelectPresentationClassDTO {
    private int trainCount;
    private double total_completion_rate;   //班级总完成率
    private double one_completion_rate;     //动作1完成率
    private double two_completion_rate;     //动作2完成率
    private double three_completion_rate;   //动作3完成率
    private double four_completion_rate;    //动作4完成率
    private List total_rateList;
    private List one_rateList;
    private List two_rateList;
    private List three_rateList;
    private List four_rateList;
}
