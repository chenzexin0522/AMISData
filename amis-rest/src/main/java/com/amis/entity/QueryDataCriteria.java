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
    private String startDate;   //开始时间
    private String endDate;     //结束时间

}
