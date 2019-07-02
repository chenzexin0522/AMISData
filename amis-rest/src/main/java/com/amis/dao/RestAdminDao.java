package com.amis.dao;

import com.amis.entity.*;
import com.amis.entity.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName RestAdminDao
 * @Description 后台管理
 * @Author chenzexin
 * @Date 2019/4/17 17:43
 **/
@Mapper
public interface RestAdminDao {
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

    School getSchoolIP();

    int addCoachClass(Users users);

    int addAdmin(Admin admin);

    UpdateStudent updatestudent(int uc_id);

    String selectStudentPage();

    String selectTrainPage();

    String selectClassPage();

    PageStatisticsDTO selectPageStatistics(Presentation presentation);

    String selectWeekCompletionRrate(@Param("tab_total_train")String tab_total_train,@Param("tab_result") String tab_result);

    int updatestudentVal(Student student);

    List<GradeDTO> selectgradeDTOS(@Param("tab_total_train")String tab_total_train,@Param("tab_result") String tab_result);

    String selectWeekClassCompletionRrate(@Param("tab_total_train")String tab_total_train,@Param("tab_result") String tab_result);

    List<ClassTotalDTO> selecClassTotalDTOS(@Param("tab_total_train")String tab_total_train,@Param("tab_result") String tab_result);

    int updateCoachVal(Users users);

    int updateClassVal(ClassEntity classEntity);

    UpdateTrainDTO updateTrain(int u_id);

    List<StudentTrainTotalList> getStudentTrain(@Param("uc_id") int uc_id,@Param("start_time") String start_time,@Param("end_time") String end_time);

    List<ClassTrainExcelDTO>  getClassTrainExcel(@Param("tc_id")int tc_id,@Param("start_time")String start_time,@Param("end_time")String end_time);
}
