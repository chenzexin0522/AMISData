package com.amis.entity;

import lombok.Data;

/**
 * @ClassName PhoneCode
 * @Description 手机验证码实体类
 * @Author chenzexin
 * @Date 2019/3/18 10:44
 **/
@Data
public class PhoneCode {
    private int p_id;
    private String p_phone;
    private String p_verCode;
    private String u_phone;
}
