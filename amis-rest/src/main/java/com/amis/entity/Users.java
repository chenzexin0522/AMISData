package com.amis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {

    private static final long serialVersionUID = 3192236069956065303L;

    private String token;
    private int u_id;
    private String u_name;
    private String u_gender;
    private String u_phone;
    private String u_password;
    private String newPassword;         //新密码，修改密码时使用
    private String u_picture;
    private int coach_teaching_age;     //教练教龄
    private String coach_title;         //教练称号
    private String u_autograph;         //个性签名
    private int u_role;                 //用户角色
    private int s_id;
    private int matchMode;
    private String modelPath;
    private int isModelUpdate;
    private int log_state;              //登录状态1-在线状态，2-离线状态

}
