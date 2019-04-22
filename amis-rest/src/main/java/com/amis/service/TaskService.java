package com.amis.service;

import com.amis.entity.Task;
import com.amis.entity.dto.ReturnTaskListDTO;
import com.amis.entity.dto.SelectStudentTaskDetails;

import java.util.List;

/**
 * @InterfaceName TaskService
 * @Description 作业Service
 * @Author chenzexin
 * @Date 2019/4/8 17:25
 **/
public interface TaskService {
    void insertTask(Task task);

    List<ReturnTaskListDTO> selectTaskList(int u_id);

    SelectStudentTaskDetails selectStudentTask(int tc_id);

    int deleteTask(int ta_id);
}
