package com.amis.entity;

import lombok.Data;

/**
 * @ClassName QueryDataCriteria
 * @Description 查询数据条件
 * @Author chenzexin
 * @Date 2019/8/12 15:12
 **/

@Data
public class QueryDataCriteria {
    private String mac;     //设备mac
    private long startDate;   //开始时间
    private long endDate;     //结束时间
    private String dateTimeStr;         //日期格式化
    private int analysisType;           //是否需要解析，1：表示需要解析，0：不需要解析
}
