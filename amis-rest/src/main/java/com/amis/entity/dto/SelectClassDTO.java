package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName SelectClassDTO
 * @Description 查询班级DTO
 * @Author chenzexin
 * @Date 2019/4/2 13:19
 **/
@Data
public class SelectClassDTO {
    private int tc_id;
    private String tc_name;     //班级名称
    private int tc_number;      //班级人数
}
