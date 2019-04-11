package com.amis.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName SelectStudentTaskDetails
 * @Description 学生完成数
 * @Author chenzexin
 * @Date 2019/4/8 23:12
 **/
@Data
public class SelectStudentTaskDetails {
    private List completionStudent;
    private List noCompletionStudent;
}
