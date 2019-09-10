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
    private String mac;
    private long arrindex;       //下标
    private long unixdate;         //接收的时间
    private String data;

}