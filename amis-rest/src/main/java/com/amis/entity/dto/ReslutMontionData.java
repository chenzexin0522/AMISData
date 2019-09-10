package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReslutMontionData
 * @Description
 * @Author chenzexin
 * @Date 2019/8/14 15:04
 **/

@Data
public class ReslutMontionData {
    private int id;
    private String mac;
    private long receiveTime;         //接收的时间
    private long arrindex;       //下标
    private float[] ax;
    private float[] ay;
    private float[] az;
    private float[] gx;
    private float[] gy;
    private float[] gz;
}
