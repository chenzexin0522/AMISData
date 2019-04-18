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
    private int ad_id;
    private String ad_name;
    private String ad_phone;
    private String ad_password;
}
