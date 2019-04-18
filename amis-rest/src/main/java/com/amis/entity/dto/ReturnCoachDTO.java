package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnCoachDTO
 * @Description 教练DTO
 * @Author chenzexin
 * @Date 2019/4/18 14:01
 **/
@Data
public class ReturnCoachDTO {
    private int u_id;
    private String u_name;
    private String u_gender;
    private String u_phone;
    private int coach_teaching_age;     //教练教龄
    private String coach_title;         //教练称号
    private String s_name;
}
