package com.amis.service.impl;

import com.amis.dao.SelectClassDao;
import com.amis.entity.dto.SelectClassDTO;
import com.amis.entity.dto.SelectCoachDTO;
import com.amis.entity.dto.SelectStudentDTO;
import com.amis.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SelectServiceImpl
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 16:26
 * @Description
 **/
@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectClassDao selectClassDao;

    @Override
    public List<SelectClassDTO> selectClass(int s_id) {
        return selectClassDao.selectClass(s_id);
    }

    @Override
    public List<SelectCoachDTO> selectCoach(int s_id) {
        return selectClassDao.selectCoach(s_id);
    }

    @Override
    public List<SelectClassDTO> coachSelectClass(int u_id) {
        return selectClassDao.coachSelectClass(u_id);
    }

    @Override
    public List<SelectStudentDTO> selectStudent(int tc_id) {
        return selectClassDao.selectStudent(tc_id);
    }
}
