package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnMotionDataDTO
 * @Description
 * @Author chenzexin
 * @Date 2019/8/28 20:22
 **/

@Data
public class ReturnMotionDataDTO {
    private int id;
    private String mac;
    private long receiveTime;
    private int arrindex;
}
