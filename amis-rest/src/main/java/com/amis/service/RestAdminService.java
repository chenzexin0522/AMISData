package com.amis.service;

import com.amis.entity.*;
import com.amis.entity.dto.EquipmentDTO;
import com.amis.entity.dto.ReturnCoachDTO;

import java.util.List;

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

    Admin adminlogin(Admin admin);

    List<School> selectSchoolList();

    int addSchool(School school);

    int deleteSchool(int s_id);

    int updateSchool(School school);

    List<ReturnCoachDTO> selectCoachlList();

    int addCoach(Users users);

    int deleteCoach(int u_id);

    List<Student> selectStudentList();

    int addStudent(Student student);

    int deleteStudent(int uc_id);

    List<EquipmentDTO> selectEquipmentList();

    int addEquipment(Equipment equipment);

    int deleteEquipment(int te_id);
}
