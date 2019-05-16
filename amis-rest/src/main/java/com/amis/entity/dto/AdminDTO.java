package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName AdminDTO
 * @Description 管理员dto
 * @Author chenzexin
 * @Date 2019/4/28 16:07
 **/
@Data
public class AdminDTO {
    private int user_id;
    private String token;
    private String user_name;
    private String user_phone;
    private int user_role;
}
