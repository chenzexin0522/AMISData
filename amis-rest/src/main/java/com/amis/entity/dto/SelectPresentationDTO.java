package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName SelectPresentationDTO
 * @Description 查询指定报告
 * @Author chenzexin
 * @Date 2019/4/8 9:43
 **/
@Data
public class SelectPresentationDTO {
    private double total_completion_rate;   //班级总完成率
    private double one_completion_rate;     //动作1完成率
    private double two_completion_rate;     //动作2完成率
    private double three_completion_rate;   //动作3完成率
    private double four_completion_rate;    //动作4完成率
}
