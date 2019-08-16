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

    private String mac;         //设备mac地址
    private Integer[] ax;
    private Integer[] ay;
    private Integer[] az;
    private Integer[] gx;
    private Integer[] gy;
    private Integer[] gz;

}
