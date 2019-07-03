package com.amis.service.impl;

import com.amis.dao.TaskDao;
import com.amis.entity.Student;
import com.amis.entity.Task;
import com.amis.entity.YmlEntityTab;
import com.amis.entity.dto.ReturnTaskListDTO;
import com.amis.entity.dto.SelectStudentTaskDetails;
import com.amis.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TaskServiceImpl
 * @Description 作业Service实现类
 * @Author chenzexin
 * @Date 2019/4/8 17:26
 **/
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void insertTask(Task task) {
        task.setTab_task(YmlEntityTab.tab_task);
        taskDao.insertTask(task);
    }

    @Override
    public List<ReturnTaskListDTO> selectTaskList(int u_id) {
        return taskDao.selectTaskList(u_id,YmlEntityTab.tab_task);
    }

    @Override
    public SelectStudentTaskDetails selectStudentTask(int tc_id) {
        SelectStudentTaskDetails selectStudentTaskDetails = new SelectStudentTaskDetails();
        List<Student> studentsList = taskDao.selectStudentList(tc_id,YmlEntityTab.tab_task);
        List completion_number = new ArrayList();
        for (Student student:studentsList) {
            completion_number.add(student.getUc_name());
        }
        selectStudentTaskDetails.setCompletionStudent(completion_number);
        List<Student> noStudentsList = taskDao.selectStudentList(2,YmlEntityTab.tab_task);
        List noCompletion_number = new ArrayList();
        for (Student student : noStudentsList) {
            noCompletion_number.add(student.getUc_name());
        }
        selectStudentTaskDetails.setNoCompletionStudent(noCompletion_number);

        return selectStudentTaskDetails;
    }

    @Override
    public int deleteTask(int ta_id) {
        return taskDao.deleteTask(ta_id,YmlEntityTab.tab_task);
    }
}
