package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName FeedbackDTO
 * @Description 查询所有反馈信息
 * @Author chenzexin
 * @Date 2019/4/19 14:18
 **/
@Data
public class FeedbackDTO {
    private int tf_id;
    private String tf_content;      //反馈内  容
    private String tf_time;         //反馈时间
    private String u_name;          //用户昵称
}
