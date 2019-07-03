package com.amis.dao;

import com.amis.entity.dto.SelectClassDTO;
import com.amis.entity.dto.SelectCoachDTO;
import com.amis.entity.dto.SelectStudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName SelectClassDao
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 16:29
 **/
@Mapper
public interface SelectClassDao {
    List<SelectClassDTO> selectClass(int s_id);

    List<SelectCoachDTO> selectCoach(int s_id);

    List<SelectClassDTO> coachSelectClass(int u_id);

    List<SelectStudentDTO> selectStudent( @Param("tc_id") int tc_id, @Param("tab_result") String tab_result,@Param("tab_total_train") String tab_total_train);
}
