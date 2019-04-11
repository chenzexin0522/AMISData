package com.amis.service;

import com.amis.entity.dto.SelectClassDTO;
import com.amis.entity.dto.SelectCoachDTO;
import com.amis.entity.dto.SelectStudentDTO;

import java.util.List;

/**
 * @InterfaceName SelectService
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 16:25
 **/
public interface SelectService {

    List<SelectClassDTO> selectClass(int s_id);

    List<SelectCoachDTO> selectCoach(int s_id);

    List<SelectClassDTO> coachSelectClass(int u_id);

    List<SelectStudentDTO> selectStudent(int tc_id);
}
