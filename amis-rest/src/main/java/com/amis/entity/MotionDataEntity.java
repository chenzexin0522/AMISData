package com.amis.entity;

import lombok.Data;

/**
 * @ClassName motionDataEntity
 * @Description 运动数据实体类
 * @Author chenzexin
 * @Date 2019/8/9 10:39
 **/

@Data
public class MotionDataEntity {

    private int id;
    private String Ax;
    private String Ay;
    private String Az;
    private String Gx;
    private String Gy;
    private String Gz;
    private String Mac;
    private String ReceiveTime;         //接收的时间
    private String data;

}