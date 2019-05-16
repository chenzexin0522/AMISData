package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName PageStatisticsDTO
 * @Description 后台系统首页数据统计
 * @Author chenzexin
 * @Date 2019/5/14 14:12
 **/
@Data
public class PageStatisticsDTO {

    private int trainTotal;      //课程总次数
    private int totalTrainMinute;    //课程总分钟数
    private int totalCompletionRrate;      //平均完成率

}
