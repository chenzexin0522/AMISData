package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName SelectCoachDTO
 * @Description 根据学校id查询学校旗下所有教练
 * @Author chenzexin
 * @Date 2019/4/2 13:38
 **/
@Data
public class SelectCoachDTO {

    private int u_id;
    private String u_name;
    private String u_gender;
    private String u_phone;
    private String u_picture;
    private int coach_teaching_age;     //教练教龄
    private String coach_title;         //教练称号
    private String u_autograph;         //个性签名
    private String uuid;
    private int u_role;                 //用户角色
}
