package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Feedback
 * @Description 反馈实体类
 * @Author chenzexin
 * @Date 2019/4/19 13:45
 **/
@Data
public class Feedback {

    private int tf_id;          //反馈id
    private int tf_type;        //反馈类型
    private String tf_content;  //反馈内容
    private String tf_time;     //反馈时间
    private int u_id;           //用户id
}
