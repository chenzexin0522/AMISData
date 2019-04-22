package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName TrainLog
 * @Description 用户个人模型
 * @Author chenzexin
 * @Date 2019/4/22 15:37
 **/
@Data
public class TrainLog {
    private int u_id;
    private String insertTime;
    private String fileUrl;
}
