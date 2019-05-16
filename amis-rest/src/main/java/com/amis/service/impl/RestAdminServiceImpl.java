package com.amis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amis.common.http.HttpRequest;
import com.amis.dao.EditionDao;
import com.amis.dao.RestAdminDao;
import com.amis.entity.*;
import com.amis.entity.dto.*;
import com.amis.service.RestAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private EditionDao editionDao;

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
    public AdminDTO adminlogin(Admin admin) {
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
    public List<ReturnStudentListDTO> selectStudentList() {
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

    @Override
    public List<AdminClass> selectClass() {
        return restAdminDao.selectClass();
    }

    @Override
    public ReturnCoachDTO selectClassCoach(int tc_id) {
        return restAdminDao.selectClassCoach(tc_id);
    }

    @Override
    public List<ReturnStudentListDTO> selectClassStudent(int tc_id) {
        return restAdminDao.selectClassStudent(tc_id);
    }

    @Override
    public int addClass(ClassEntity classEntity) {
        return restAdminDao.addClass(classEntity);
    }

    @Override
    public int deleteClass(int tc_id) {
        return restAdminDao.deleteClass(tc_id);
    }

    @Override
    public void updateAPK() {
        Edition edition = editionDao.getEdition();
        School school = restAdminDao.getSchoolIP();
        String IP = school.getS_ip();
        JSONObject jsobj1 = new JSONObject();
        jsobj1.put("versionCode",edition.getVersionCode());
        jsobj1.put("isUpdate",edition.getIsUpdate());
        jsobj1.put("message",edition.getMessage());
        jsobj1.put("fileUrl",edition.getFileUrl());
        jsobj1.put("isHotUpdate",edition.getIsHotUpdate());
        jsobj1.put("hotCode",edition.getHotCode());
        jsobj1.put("editionReleasePeople",edition.getEditionReleasePeople());
        //System.out.println(jsobj1);
        HttpRequest.post(jsobj1,"http://"+IP+"/updateAll/updateAPK");//注册


    }

    @Override
    public int addCoachClass(Users users) {
        return restAdminDao.addCoachClass(users);
    }

    @Override
    public int addAdmin(Admin admin) {
        return restAdminDao.addAdmin(admin);
    }

    @Override
    public UpdateStudent updatestudent(int uc_id) {
        return restAdminDao.updatestudent(uc_id);
    }

    @Override
    public Map<String, Object> loginPageS() {
        Map<String, Object> map = new HashMap<>();
        String studentPage = restAdminDao.selectStudentPage();  //查询学生总数
        String trainPage = restAdminDao.selectTrainPage();      //查询教练总数
        String classPage = restAdminDao.selectClassPage();      //查询班级总数
        PageStatisticsDTO pageStatisticsDTO = restAdminDao.selectPageStatistics();  //学生体育课程平均完成率
        int trainTotal =pageStatisticsDTO.getTrainTotal();      //课程总次数
        int totalTrainMinute =pageStatisticsDTO.getTotalTrainMinute();      //课程总分钟数
        int totalCompletionRrate =pageStatisticsDTO.getTotalCompletionRrate();      //平均完成率
        String weekCompletionRrate = restAdminDao.selectWeekCompletionRrate();  //查询本周学生训练完成率
        List<GradeDTO> gradeDTOS = restAdminDao.selectgradeDTOS();   //查询各年级周训练完成率
        String weekClassCompletionRrate = restAdminDao.selectWeekClassCompletionRrate();    //查询本所有周班级训练完成率
        List<ClassTotalDTO> classTotalDTOS = restAdminDao.selecClassTotalDTOS();    //查询本周各班级训练完成率
        map.put("studentPage",studentPage);
        map.put("trainPage",trainPage);
        map.put("classPage",classPage);
        map.put("trainTotal",trainTotal);
        map.put("totalTrainMinute",totalTrainMinute);
        map.put("totalCompletionRrate",totalCompletionRrate);
        map.put("weekCompletionRrate",weekCompletionRrate);
        map.put("weekClassCompletionRrate",weekClassCompletionRrate);
        map.put("gradeDTOS",gradeDTOS);
        map.put("classTotalDTOS",classTotalDTOS);
        return map;
    }

    @Override
    public int updatestudentVal(Student student) {
        return restAdminDao.updatestudentVal(student);
    }

    @Override
    public int updateCoachVal(Users users) {
        return restAdminDao.updateCoachVal(users);
    }

    @Override
    public int updateClassVal(ClassEntity classEntity) {
        return restAdminDao.updateClassVal(classEntity);
    }


}
