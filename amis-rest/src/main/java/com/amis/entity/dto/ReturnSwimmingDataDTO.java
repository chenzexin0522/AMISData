package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnSwimmingDataDTO
 * @Description
 * @Author chenzexin
 * @Date 2019/9/10 19:23
 **/
@Data
public class ReturnSwimmingDataDTO {

    private String mac;
    private float Ax;
    private float Ay;
    private float Az;
    private float Gx;
    private float Gy;
    private float Gz;

}
