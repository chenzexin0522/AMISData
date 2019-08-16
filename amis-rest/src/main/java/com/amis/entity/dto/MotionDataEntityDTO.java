package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName MotionDataEntityDTO
 * @Description 运动数据DTO
 * @Author chenzexin
 * @Date 2019/8/12 15:22
 **/

@Data
public class MotionDataEntityDTO {

    private int id;
    private String Ax;
    private String Ay;
    private String Az;
    private String Gx;
    private String Gy;
    private String Gz;
    private String Mac;
    private String ReceiveTime;         //接收的时间
}
