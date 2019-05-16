package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Admin
 * @Description 管理员
 * @Author chenzexin
 * @Date 2019/4/17 18:56
 **/
@Data
public class Admin {
    private int user_id;
    private String token;
    private String user_name;
    private String user_phone;
    private String user_password;
    private int user_role;
}
