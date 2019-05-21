package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName GradeDTO
 * @Description 年级dto
 * @Author chenzexin
 * @Date 2019/5/15 13:55
 **/
@Data
public class GradeDTO {
    private String gr_name;                 //年级名
    private int total_completion_rate;      //年级体育训练颗平均完成率

}
