package com.amis.service;

import com.amis.entity.*;
import com.amis.entity.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName RestAdminService
 * @Description 后台管理
 * @Author chenzexin
 * @Date 2019/4/17 17:41
 **/
public interface RestAdminService {

    List<Edition> selectEditionList();

    int deleteEdition(int tet_id);

    int updateEdition(Edition edition);

    AdminDTO adminlogin(Admin admin);

    List<School> selectSchoolList();

    int addSchool(School school);

    int deleteSchool(int s_id);

    int updateSchool(School school);

    List<ReturnCoachDTO> selectCoachlList();

    int addCoach(Users users);

    int deleteCoach(int u_id);

    List<ReturnStudentListDTO> selectStudentList();

    int addStudent(Student student);

    int deleteStudent(int uc_id);

    List<EquipmentDTO> selectEquipmentList();

    int addEquipment(Equipment equipment);

    int deleteEquipment(int te_id);

    List<FeedbackDTO> selectFeedback();

    List<AdminClass> selectClass();

    ReturnCoachDTO selectClassCoach(int tc_id);

    List<ReturnStudentListDTO> selectClassStudent(int tc_id);

    int addClass(ClassEntity classEntity);

    int deleteClass(int tc_id);

    void updateAPK();

    int addCoachClass(Users users);

    int addAdmin(Admin admin);

    UpdateStudent updatestudent(int uc_id);

    Map<String, Object> loginPageS();

    int updatestudentVal(Student student);

    int updateCoachVal(Users users);

    int updateClassVal(ClassEntity classEntity);
}
