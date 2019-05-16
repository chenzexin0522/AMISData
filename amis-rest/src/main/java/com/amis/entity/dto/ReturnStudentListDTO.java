package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnStudentListDTO
 * @Description 返回学生列表
 * @Author chenzexin
 * @Date 2019/4/18 15:23
 **/
@Data
public class ReturnStudentListDTO {
    private int uc_id;
    private String uc_name;         //学生昵称
    private String uc_phone;        //学生手机号
    private String eq_mac;          //学生设备mac
    private String tc_name;              //班级id
    private int tc_id;
}
