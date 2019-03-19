package com.amis.entity;

import lombok.Data;

/**
 * @ClassName UserPhoneCode
 * @Description 用户忘记密码临时实体类、
 * @Author chenzexin
 * @Date 2019/3/18 18:25
 **/
@Data
public class UserPhoneCode {
    String phone;
    String newPassword;
    String verCode;
}
