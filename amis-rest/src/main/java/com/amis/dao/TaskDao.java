package com.amis.dao;

import com.amis.entity.Student;
import com.amis.entity.Task;
import com.amis.entity.dto.ReturnTaskListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName TaskDao
 * @Description 作业Dao层
 * @Author chenzexin
 * @Date 2019/4/8 17:26
 **/
@Mapper
public interface TaskDao {

    void insertTask(Task task);

    List<ReturnTaskListDTO> selectTaskList(int u_id);

    List<Student> selectStudentList(int tc_id);
}
