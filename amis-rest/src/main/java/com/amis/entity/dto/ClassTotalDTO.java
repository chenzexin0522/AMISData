package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ClassTotalDTO
 * @Description 班级完成率DTO
 * @Author chenzexin
 * @Date 2019/5/15 14:17
 **/
@Data
public class ClassTotalDTO {
    private String tc_name;             //班级名称
    private int total_completion_rate;  //本机训练平均完成率
}
