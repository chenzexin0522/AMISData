package com.amis.entity;

import lombok.Data;

/**
 * @ClassName School
 * @Description 学校
 * @Author chenzexin
 * @Date 2019/4/17 19:29
 **/
@Data
public class School {
    private int s_id;
    private String s_name;
    private String s_province;      //学校省份
    private String s_city;          //学生市区
}
