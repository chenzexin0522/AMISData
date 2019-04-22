package com.amis.service.impl;

import com.amis.dao.RestAdminDao;
import com.amis.entity.*;
import com.amis.entity.dto.EquipmentDTO;
import com.amis.entity.dto.FeedbackDTO;
import com.amis.entity.dto.ReturnCoachDTO;
import com.amis.service.RestAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RestAdminServiceImpl
 * @Description 后台管理
 * @Author chenzexin
 * @Date 2019/4/17 17:42
 **/
@Service
public class RestAdminServiceImpl implements RestAdminService {

    @Autowired
    private RestAdminDao restAdminDao;

    @Override
    public List<Edition> selectEditionList() {
        return restAdminDao.selectEditionList();
    }

    @Override
    public int deleteEdition(int tet_id) {
        return restAdminDao.deleteEdition(tet_id);
    }

    @Override
    public int updateEdition(Edition edition) {
        return restAdminDao.updateEdition(edition);
    }

    @Override
    public Admin adminlogin(Admin admin) {
        return restAdminDao.adminlogin(admin);
    }

    @Override
    public List<School> selectSchoolList() {
        return restAdminDao.selectSchoolList();
    }

    @Override
    public int addSchool(School school) {
        return restAdminDao.addSchool(school);
    }

    @Override
    public int deleteSchool(int s_id) {
        return restAdminDao.deleteSchool(s_id);
    }

    @Override
    public int updateSchool(School school) {
        return restAdminDao.updateSchool(school);
    }

    @Override
    public List<ReturnCoachDTO> selectCoachlList() {
        return restAdminDao.selectCoachlList();
    }

    @Override
    public int addCoach(Users users) {
        return restAdminDao.addCoach(users);
    }

    @Override
    public int deleteCoach(int u_id) {
        return restAdminDao.deleteCoach(u_id);
    }

    @Override
    public List<Student> selectStudentList() {
        return restAdminDao.selectStudentList();
    }

    @Override
    public int addStudent(Student student) {
        return restAdminDao.addStudent(student);
    }

    @Override
    public int deleteStudent(int uc_id) {
        return restAdminDao.deleteStudent(uc_id);
    }

    @Override
    public List<EquipmentDTO> selectEquipmentList() {
        return restAdminDao.selectEquipmentList();
    }

    @Override
    public int addEquipment(Equipment equipment) {
        return restAdminDao.addEquipment(equipment);
    }

    @Override
    public int deleteEquipment(int te_id) {
        return restAdminDao.deleteEquipment(te_id);
    }

    @Override
    public List<FeedbackDTO> selectFeedback() {
        return restAdminDao.selectFeedback();
    }

}
