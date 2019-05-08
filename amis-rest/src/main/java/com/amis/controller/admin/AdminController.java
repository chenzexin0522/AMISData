package com.amis.controller.admin;

import com.amis.entity.*;
import com.amis.entity.dto.AdminClass;
import com.amis.entity.dto.AdminDTO;
import com.amis.entity.dto.FeedbackDTO;
import com.amis.entity.dto.ReturnCoachDTO;
import com.amis.service.AdminService;
import com.amis.service.RestAdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
     * @Date 2019/5/7 16:56
     * @param request
     * @param session
     * @param model
     * @return java.lang.String
     * @Description        登录首页
     **/
    @RequestMapping(value = "/loginPage",method = {RequestMethod.POST, RequestMethod.GET})
    public String loginSub(HttpServletRequest request, HttpSession session, Model model){
        String phone = request.getParameter("username");
        String passowrd = request.getParameter("password");
        Admin admin = new Admin();
        admin.setUser_phone(phone);
        admin.setUser_password(passowrd);
        if (StringUtils.isBlank(phone) && StringUtils.isBlank(passowrd)) {
            return "indexcopy";
        }
        AdminDTO adminDTO = restAdminService.adminlogin(admin);
        model.addAttribute("aloo","aimsshou");
        model.addAttribute("admin",adminDTO);
        model.addAttribute("title","AIMS首页");
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
        return "login";
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
        return "aimsshou";
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
        List<Student> students = restAdminService.selectStudentList();
        model.addAttribute("student",students);
        return "studenttable";
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

    @RequestMapping("/deletestudentVal")
    public String deletestudentVal(HttpServletRequest request, HttpSession session, Model model){
        int uc_id = Integer.parseInt(request.getParameter("id"));
        int a = restAdminService.deleteStudent(uc_id);
        List<Student> students = restAdminService.selectStudentList();
        model.addAttribute("student",students);
        return "addstudent";
    }


    @RequestMapping("/updatestudent")
    public String updatestudent(){
        return "updatestudent";
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
