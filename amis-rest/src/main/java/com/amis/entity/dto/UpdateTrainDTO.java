package com.amis.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName UpdateTrainDTO
 * @Description
 * @Author chenzexin
 * @Date 2019/5/17 18:26
 **/
@Data
public class UpdateTrainDTO {
    private int u_id;
    private String u_name;
    private String u_phone;
    private String coach_teaching_age;
    private String coach_title;
}
