package com.amis.dao;

import com.amis.entity.dto.ClassTrainTabDTO;
import com.amis.entity.dto.ReturnTotalList;
import com.amis.entity.dto.StudentTrainList;
import com.amis.entity.dto.StudentTrainTab;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName FromListDao
 * @Description 训练报表
 * @Author chenzexin
 * @Date 2019/4/2 19:33
 **/
@Mapper
public interface FromListDao {

    List<ReturnTotalList> selectFromList(int u_id);

    ClassTrainTabDTO selectTotalTab(int tt_id);

    List<StudentTrainList> selectStudentList(int tt_id);

    StudentTrainTab selectStudentTab(int tr_id);
}
