package com.amis.entity;

import lombok.Data;

/**
 * @ClassName ClassEntity
 * @Description 班级类实体
 * @Author chenzexin
 * @Date 2019/3/12 16:04
 * @Description
 **/
@Data
public class ClassEntity {

    private int tc_id;
    private String tc_name;     //班级名称
    private int tc_number;      //班级人数
    private int s_id;      //班级人数
}
