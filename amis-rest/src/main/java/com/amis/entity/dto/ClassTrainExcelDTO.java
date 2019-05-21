package com.amis.entity.dto;

import lombok.Data;

/**
 * @ClassName ClassTrainExcelDTO
 * @Description
 * @Author chenzexin
 * @Date 2019/5/20 14:59
 **/
@Data
public class ClassTrainExcelDTO {
    private String start_time;
    private String end_time;
    private String train_people_number;
    private String one_completion_rate;
    private String two_completion_rate;
    private String three_completion_rate;
    private String four_completion_rate;
    private String total_completion_rate;
}
