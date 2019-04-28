package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName SelectStudentDTO
 * @Description 根据班级id查询班级所有学生
 * @Author chenzexin
 * @Date 2019/4/2 14:57
 **/
@Data
public class SelectStudentDTO {
    private int uc_id;
    private String uc_name;
    private String uc_gender;
    private String uc_phone;
    private String uc_picture;
    private String uuid;
    private String uc_autograph;
    private String eq_mac;
    private int u_role;                 //用户角色
    private int past_completion_rate;  //以往完成率
}
