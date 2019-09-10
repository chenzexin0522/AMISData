package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ReturnJieMotionDataDTO
 * @Description
 * @Author chenzexin
 * @Date 2019/9/5 16:30
 **/
@Data
public class ReturnJieMotionDataDTO {

    private int id;
    private String mac;
    private long arrindex;       //下标
    private long receiveTime1;         //接收的时间
    private String motionData1;
    private long receiveTime2;         //接收的时间
    private String motionData2;
    private long receiveTime3;         //接收的时间
    private String motionData3;
}
