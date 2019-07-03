package com.amis.dao;

import com.amis.entity.Student;
import com.amis.entity.Task;
import com.amis.entity.dto.ReturnTaskListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<ReturnTaskListDTO> selectTaskList(@Param("u_id") int u_id, @Param("tab_task") String tab_task);

    List<Student> selectStudentList(@Param("tc_id") int tc_id, @Param("tab_task") String tab_task);

    int deleteTask(@Param("ta_id") int ta_id, @Param("tab_task") String tab_task);
}
