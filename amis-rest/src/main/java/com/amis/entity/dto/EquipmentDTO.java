package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName EquipmentDTO
 * @Description 设备DTO
 * @Author chenzexin
 * @Date 2019/4/18 16:15
 **/
@Data
public class EquipmentDTO {
    private int te_id;
    private String te_mac;          //设备mac
    private String uc_name;              //学生id
    private String te_edition;      //设备版本
}
