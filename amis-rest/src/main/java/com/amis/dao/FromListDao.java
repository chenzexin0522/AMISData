package com.amis.dao;

import com.amis.entity.YmlEntityTab;
import com.amis.entity.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName FromListDao
 * @Description 训练报表
 * @Author chenzexin
 * @Date 2019/4/2 19:33
 **/
@Mapper
public interface FromListDao {

    List<ReturnTotalList> selectFromList(@Param("u_id") int u_id,@Param("tab_total_train") String tab_total_train,@Param("tab_result") String tab_result);

    ClassTrainTabDTO selectTotalTab(@Param("tt_id")int tt_id,@Param("tab_total_train") String tab_total_train,@Param("tab_result") String tab_result);

    List<StudentTrainList> selectStudentList(@Param("tt_id")int tt_id,@Param("tab_result") String tab_result);

    StudentTrainTab selectStudentTab(@Param("tr_id")int tr_id,@Param("tab_total_train") String tab_total_train,@Param("tab_result") String tab_result);

    List<QueryClassReportDTO> queryClassReport(QueryClassReportDTO queryClassReportDTO);
}
