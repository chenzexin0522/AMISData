package com.amis.controller.admin;

import com.amis.entity.*;
import com.amis.entity.dto.*;
import com.amis.service.RestAdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminController
 * @Description 后台管理
 * @Author chenzexin
 * @Date 2019/3/28 15:20
 **/
@Controller
@RequestMapping(value = "admines")
public class AdminController {

    @Autowired
    private RestAdminService restAdminService;


    /**
     * @Author chenzexin
     * @Date 2019/5/31 10:09
     * @param
     * @return java.lang.String
     * @Description        忘记密码
     **/
    @RequestMapping("/forgetPassword")
    public String forgetPassword(){
        return "forgetPassword";
    }



    /**
     * @Author chenzexin
     * @Date 2019/7/5 10:27
     * @param
     * @return java.lang.String
     * @Description        AIMS下载
     **/
    @RequestMapping("/montionDataViewDong")
    public String montionDataViewDong(){
        return "montionDataViewDong";
    }

    /**
     * @Author chenzexin
     * @Date 2019/7/5 10:27
     * @param
     * @return java.lang.String
     * @Description        AIMS下载
     **/
    @RequestMapping("/downloadAims")
    public String downloadAims(){
        return "downloadAims";
    }


    /**
     * @Author chenzexin
     * @Date 2019/5/17 10:15
     * @param model
     * @return java.util.List<com.amis.entity.dto.GradeDTO>
     * @Description        查询各年级周训练完成率
     **/
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<GradeDTO> findById(Model model) {
        List<GradeDTO> gradeDTOS = restAdminService.selectgradeDTOS();
        return gradeDTOS;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 10:24
     * @param model
     * @return java.util.List<com.amis.entity.dto.GradeDTO
     * @Description        查询各年级周训练完成率
     **/
    @RequestMapping(value = "/selectStudentListTable")
    @ResponseBody
    public List<GradeDTO> selectStudentListTable(Model model) {
        List<GradeDTO> gradeDTOS = restAdminService.selectgradeDTOS();
        return gradeDTOS;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 11:31
     * @param model
     * @return java.lang.String
     * @Description        查询本周学生训练完成率
     **/
    @RequestMapping(value = "/selectWeekCompletionRrate")
    @ResponseBody
    public String selectWeekCompletionRrate(Model model) {
        String weekCompletionRrate = restAdminService.selectWeekCompletionRrate();
        return weekCompletionRrate;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 12:15
     * @param model
     * @return java.lang.String
     * @Description        查询本周学生作业完成率
     **/
    @RequestMapping(value = "/selectWeekCompletionRrateTable")
    @ResponseBody
    public String selectWeekCompletionRrateTable(Model model) {
        String WeekCompletionRrateTable = restAdminService.selectWeekCompletionRrateTable();
        return WeekCompletionRrateTable;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 12:17
     * @param model
     * @return java.lang.String
     * @Description        查询本周所有周班级训练完成率
     **/
    @RequestMapping(value = "/selectWeekClassCompletionRrate")
    @ResponseBody
    public String selectWeekClassCompletionRrate(Model model) {
        String WeekClassCompletionRrate = restAdminService.selectWeekClassCompletionRrate();
        return WeekClassCompletionRrate;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 12:17
     * @param model
     * @return java.lang.String
     * @Description        查询本周所有周班级作业完成率
     **/
    @RequestMapping(value = "/selectWeekClassCompletionRrateTable")
    @ResponseBody
    public String selectWeekClassCompletionRrateTable(Model model) {
        String WeekClassCompletionRrateTable = restAdminService.selectWeekClassCompletionRrateTable();
        return WeekClassCompletionRrateTable;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 14:10
     * @param model
     * @return java.util.List<com.amis.entity.dto.ClassTotalDTO>
     * @Description        查询本周各班级训练完成率排名
     **/
    @RequestMapping(value = "/selecClassTotalDTOS")
    @ResponseBody
    public List<ClassTotalDTO> selecClassTotalDTOS(Model model) {
        List<ClassTotalDTO> classTotalDTOS = restAdminService.selecClassTotalDTOS();
        return classTotalDTOS;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 14:10
     * @param model
     * @return java.util.List<com.amis.entity.dto.ClassTotalDTO>
     * @Description        查询本周各班级作业完成率排名
     **/
    @RequestMapping(value = "/selecClassTableTotalDTOS")
    @ResponseBody
    public List<ClassTotalDTO> selecClassTableTotalDTOS(Model model) {
        List<ClassTotalDTO> classTotalDTOS = restAdminService.selecClassTotalDTOS();
        return classTotalDTOS;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/17 15:19
     * @param model
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @Description        数据统计
     **/
    @RequestMapping(value = "/selectDataStatistics")
    @ResponseBody
    public Map<String,String> selectDataStatistics(Model model) {
        Map<String,String> map = restAdminService.selectDataStatistics();
        return map;
    }


    /**
     * @Author chenzexin
     * @Date 2019/5/17 16:01
     * @param model
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @Description        按时间查询学生体育完成率
     **/
    @RequestMapping(value = "/selectStudentCurriculum")
    @ResponseBody
    public Map<String,String> selectStudentCurriculum(HttpServletRequest request, HttpSession session,Model model) {
        Presentation presentation = new Presentation();
        presentation.setStart_time(request.getParameter("start"));
        presentation.setEnd_time(request.getParameter("end"));
        presentation.setOpn(request.getParameter("opn"));
        System.err.println(request.getParameter("start")+"-----------------"+request.getParameter("opn"));
        Map<String,String> map = restAdminService.selectStudentCurriculum(presentation);
        return map;
    }

    @GetMapping(value = "/Echars.do")
    public String echarts4(Model model){
        System.err.println("========开始");
        return "Echars";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/7 16:56
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        登录首页
     **/
    @RequestMapping(value = "/loginPage",method = {RequestMethod.POST, RequestMethod.GET})
    public String loginSub(HttpServletRequest request, HttpSession session, Model model){
        String phone = request.getParameter("Phone");
        String passowrd = request.getParameter("Password");
        Admin admin = new Admin();
        admin.setUser_phone(phone);
        admin.setUser_password(passowrd);
        if (StringUtils.isBlank(phone) && StringUtils.isBlank(passowrd)){
            return "indexcopy";
        }
        AdminDTO adminDTO = restAdminService.adminlogin(admin);
        if (adminDTO == null || adminDTO.getUser_id() == 0 || adminDTO.getUser_name() == null) {
            return "/test/loginError";
        }
        model.addAttribute("admin",adminDTO);
        model.addAttribute("aloo","Echars");
        return "indexcopy";
    }



    /**
     * @Author chenzexin
     * @Date 2019/5/7 16:56
     * @param
     * @return java.lang.String
     * @Description        登录页面
     **/
    @RequestMapping("/login")
    public String login(){
        return "adminlogin";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/7 18:36
     * @param
     * @return java.lang.String
     * @Description        首页页面
     **/
    @RequestMapping("/aimsshou")
    public String aimsshou(){
        return "Echars";
    }


    @RequestMapping("/Echars")
    public String Echars(){
        return "Echars";
    }
    @RequestMapping("/index")
    public String index(){
        return "indexcopy";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/7 16:55
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        查询所有学校
     **/
    @RequestMapping(value = "/tables",method = {RequestMethod.POST, RequestMethod.GET})
    public String tables(HttpServletRequest request, HttpSession session, Model model){
        List<School> schools = restAdminService.selectSchoolList();
        model.addAttribute("school",schools);
        model.addAttribute("title","学校管理");
        return "tables";
    }

    @RequestMapping("/shou")
    public String shou(){
        return "shou";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 1:47
     * @param
     * @return java.lang.String
     * @Description        添加班级页面
     **/
    @RequestMapping("/addClass")
    public String addClass(){
        return "addClass";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 1:50
     * @param
     * @return java.lang.String
     * @Description        添加班级
     **/
    @RequestMapping("/addClassVal")
    public String addClassVal(HttpServletRequest request, HttpSession session, Model model){
        ClassEntity classEntity = new ClassEntity();
        classEntity.setTc_name(request.getParameter("tc_name"));
        int a = restAdminService.addClass(classEntity);
        return "addClass";
    }

    @RequestMapping("/updateclass")
    public String updateclass(){
        return "updateclass";
    }
    /**
     * @Author chenzexin
     * @Date 2019/5/7 16:55
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        查询所有学生
     **/
    @RequestMapping("/studenttable")
    public String studenttable(HttpServletRequest request, HttpSession session, Model model){
        List<ReturnStudentListDTO> students = restAdminService.selectStudentList();
        model.addAttribute("student",students);
        return "studenttable";
    }


    @RequestMapping("/excelshow")
    @ResponseBody
    public String excelshow(HttpServletRequest request, HttpSession session, Model model){
       String id = request.getParameter("id");
        return id;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/7 18:38
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        添加学生页面
     **/
    @RequestMapping("/addstudent")
    public String addstudent(HttpServletRequest request, HttpSession session, Model model){
        List<AdminClass> adminClassList = restAdminService.selectClass();
        model.addAttribute("ClassList",adminClassList);
        return "addstudent";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 0:26
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        添加学生接口
     **/
    @RequestMapping("/addstudentVal")
    public String addstudentVal(HttpServletRequest request, HttpSession session, Model model){
        Student student = new Student();
        student.setUc_name(request.getParameter("uc_name"));
        student.setUc_gender(request.getParameter("gender"));
        student.setUc_phone(request.getParameter("uc_phone"));
        student.setUc_password(request.getParameter("uc_password"));
        student.setEq_mac(request.getParameter("eq_mac"));
        student.setTc_id(Integer.parseInt(request.getParameter("tc_id")));
        int a = restAdminService.addStudent(student);
        List<AdminClass> adminClassList = restAdminService.selectClass();
        model.addAttribute("ClassList",adminClassList);
        return "addstudent";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 16:50
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        删除学生
     **/
    @RequestMapping("/deletestudentVal")
    public String deletestudentVal(HttpServletRequest request, HttpSession session, Model model){
        int uc_id = Integer.parseInt(request.getParameter("id"));
        int a = restAdminService.deleteStudent(uc_id);
        List<ReturnStudentListDTO> students = restAdminService.selectStudentList();
        model.addAttribute("student",students);
        return "studenttable";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/9 14:01
     * @param
     * @return java.lang.String
     * @Description        弹出修改教练接口
     **/
    @RequestMapping("/updateTrain")
    @ResponseBody
    public UpdateTrainDTO updateTrain(HttpServletRequest request, HttpSession session, Model model){
        int u_id = Integer.parseInt(request.getParameter("id"));
        UpdateTrainDTO updateStudent = restAdminService.updateTrain(u_id);
        model.addAttribute("updateStudent",updateStudent);
        return updateStudent;
    }


    /**
     * @Author chenzexin
     * @Date 2019/5/9 14:01
     * @param
     * @return java.lang.String
     * @Description        弹出修改学生接口
     **/
    @RequestMapping("/updatestudent")
    @ResponseBody
    public UpdateStudent updatestudent(HttpServletRequest request, HttpSession session, Model model){
        int uc_id = Integer.parseInt(request.getParameter("id"));
        UpdateStudent updateStudent = restAdminService.updatestudent(uc_id);
        updateStudent.setAdminClassList(restAdminService.selectClass());
        model.addAttribute("updateStudent",updateStudent);
        return updateStudent;
    }


    /**
     * @Author chenzexin
     * @Date 2019/5/15 13:11
     * @param request
     * @param session
     * @param model
     * @return com.amis.entity.dto.UpdateStudent
     * @Description        修改学生信息
     **/
    @RequestMapping("/updatestudentVal")
    public String updatestudentVal(HttpServletRequest request, HttpSession session, Model model){
        Student student = new Student();
        student.setUc_id(Integer.parseInt(request.getParameter("uc_id")));
        student.setUc_name(request.getParameter("uc_name"));
        student.setUc_phone(request.getParameter("uc_phone"));
        student.setEq_mac(request.getParameter("eq_mac"));
        student.setTc_id(Integer.parseInt(request.getParameter("tc_id")));
        int as = restAdminService.updatestudentVal(student);
        List<ReturnStudentListDTO> students = restAdminService.selectStudentList();
        model.addAttribute("student",students);
        return "studenttable";
    }



    /**
     * @Author chenzexin
     * @Date 2019/5/7 16:55
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        查询所有教练
     **/
    @RequestMapping("/traintable")
    public String traintable(HttpServletRequest request, HttpSession session, Model model){
        List<ReturnCoachDTO> returnCoachDTOS = restAdminService.selectCoachlList();
        model.addAttribute("coachList",returnCoachDTOS);
        return "traintable";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 1:06
     * @param
     * @return java.lang.String
     * @Description        跳转到添加教练页面
     **/
    @RequestMapping("/addtrain")
    public String addtrain(HttpServletRequest request, HttpSession session, Model model){
        List<AdminClass> adminClassList = restAdminService.selectClass();
        model.addAttribute("ClassList",adminClassList);
        return "addtrain";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 1:31
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        添加教练
     **/
    @RequestMapping("/addtrainVal")
    public String addtrainVal(HttpServletRequest request, HttpSession session, Model model){
        Users users = new Users();
        users.setU_name(request.getParameter("u_name"));
        users.setU_gender(request.getParameter("u_gender"));
        users.setU_phone(request.getParameter("u_phone"));
        users.setU_password(request.getParameter("u_password"));
        users.setCoach_teaching_age(Integer.parseInt(request.getParameter("coach_teaching_age")));
        users.setTc_id(Integer.parseInt(request.getParameter("tc_id")));
        int a = restAdminService.addCoach(users);
        int b = restAdminService.addCoachClass(users);
        List<AdminClass> adminClassList = restAdminService.selectClass();
        model.addAttribute("ClassList",adminClassList);
        return "addtrain";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 16:53
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        删除教练
     **/
    @RequestMapping("/deletetrainVal")
    public String deletetrainVal(HttpServletRequest request, HttpSession session, Model model){
        int u_id = Integer.parseInt(request.getParameter("id"));
        int a = restAdminService.deleteCoach(u_id);
        List<ReturnCoachDTO> returnCoachDTOS = restAdminService.selectCoachlList();
        model.addAttribute("coachList",returnCoachDTOS);
        return "traintable";
    }

    @RequestMapping("/updatetrain")
    public String updatetrain(){
        return "updatetrain";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/7 17:21
     * @param
     * @return java.lang.String
     * @Description        查询所有班级
     **/
    @RequestMapping("/elmtable")
    public String elmtable(HttpServletRequest request, HttpSession session, Model model){
        List<AdminClass> adminClassList = restAdminService.selectClass();
        model.addAttribute("ClassList",adminClassList);
        return "elmtable";
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/8 16:57
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        删除班级
     **/
    @RequestMapping("/deleteClassVal")
    public String deleteClassVal(HttpServletRequest request, HttpSession session, Model model){
        int tc_id = Integer.parseInt(request.getParameter("id"));
        int a = restAdminService.deleteClass(tc_id);
        List<AdminClass> adminClassList = restAdminService.selectClass();
        model.addAttribute("ClassList",adminClassList);
        return "elmtable";
    }

    @RequestMapping("/addelm")
    public String addelm(){
        return "addelm";
    }
    @RequestMapping("/updateelm")
    public String updateelm(){
        return "updateelm";
    }
    /**
     * @Author chenzexin
     * @Date 2019/5/7 17:35
     * @param
     * @return java.lang.String
     * @Description        查看所有版本
     **/
    @RequestMapping("/editiontable")
    public String editiontable(HttpServletRequest request, HttpSession session, Model model){
        List<Edition> editions = restAdminService.selectEditionList();
        model.addAttribute("editionsList",editions);
        return "editiontable";
    }

    @RequestMapping("/updateedition")
    public String updaedition(){
        return "updateedition";
    }
    @RequestMapping("/addedition")
    public String addedition(){
        return "addedition";
    }
    @RequestMapping("/files")
    public String files(){
        return "files";
    }

    @RequestMapping("/selectFeedback")
    public String selectFeedback(HttpServletRequest request, HttpSession session, Model model){
        List<FeedbackDTO> feedbackDTOSList = restAdminService.selectFeedback();
        model.addAttribute("feedbackDTOS",feedbackDTOSList);
        return "selectFeedback";
    }
}
