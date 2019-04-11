package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnPresentationDto
 * @Description 返回学生集合
 * @Author chenzexin
 * @Date 2019/4/7 1:00
 **/
@Data
public class ReturnPresentationDto {
    private int pr_id;
    private int type;
    private String start_time;
    private String end_time;
    private String tempName;
    private String gradeName;
}
