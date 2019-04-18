package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Equipment
 * @Description 设备
 * @Author chenzexin
 * @Date 2019/4/18 16:09
 **/
@Data
public class Equipment {
    private int te_id;
    private String te_mac;          //设备mac
    private int uc_id;              //学生id
    private String te_edition;      //设备版本
}
