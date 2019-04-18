package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Student
 * @Description 学生实体类
 * @Author chenzexin
 * @Date 2019/4/8 23:03
 **/
@Data
public class Student {
    private int uc_id;              //学生id
    private String uc_name;         //学生昵称
    private String uc_gender;       //学生年龄
    private String uc_phone;        //学生手机号
    private String uc_password;     //学生密码
    private String uc_picture;      //学生头像地址
    private int uuid;
    private String uc_autograph;    //学生个性签名
    private String eq_mac;          //学生设备mac
    private int tc_id;              //班级id


}
