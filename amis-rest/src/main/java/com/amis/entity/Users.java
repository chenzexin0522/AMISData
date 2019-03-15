package com.amis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {

    private static final long serialVersionUID = 3192236069956065303L;

    private int u_id;
    private String u_name;
    private String u_gender;
    private String u_phone;
    private String u_password;
    private String u_picture;
    private int coach_teaching_age;     //教练教龄
    private String coach_title;         //教练称号
    private int tc_id;                  //班级id
    private int u_role;                 //用户角色

}
