package com.amis.controller.admin;

import com.amis.entity.Users;
import com.amis.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminController
 * @Description 后台管理
 * @Author chenzexin
 * @Date 2019/3/28 15:20
 **/
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/loginPage",method = {RequestMethod.POST, RequestMethod.GET})
    public String loginSub(HttpServletRequest request, HttpSession session){
        String phone = request.getParameter("username");
        String passowrd = request.getParameter("password");
        if (StringUtils.isBlank(phone) && StringUtils.isBlank(passowrd)) {
            return "redirect:/index";
        }
        Users users = adminService.loginSub(phone,passowrd);
        System.out.println(users.getU_name());
        return "redirect:/index";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("ssss");
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("22222222111111111111111111111111111111222");
        return "indexcopy";
    }

    @RequestMapping("/tables")
    public String test(){
        return "tables";
    }

    @RequestMapping("/shou")
    public String shou(){
        return "shou";
    }

    @RequestMapping("/addClass")
    public String addClass(){
        return "addClass";
    }

    @RequestMapping("/updateclass")
    public String updateclass(){
        return "updateclass";
    }

    @RequestMapping("/studenttable")
    public String studenttable(){
        return "studenttable";
    }
    @RequestMapping("/addstudent")
    public String addstudent(){
        return "addstudent";
    }
    @RequestMapping("/updatestudent")
    public String updatestudent(){
        return "updatestudent";
    }
    @RequestMapping("/traintable")
    public String traintable(){
        return "traintable";
    }
    @RequestMapping("/addtrain")
    public String addtrain(){
        return "addtrain";
    }
    @RequestMapping("/updatetrain")
    public String updatetrain(){
        return "updatetrain";
    }
    @RequestMapping("/elmtable")
    public String elmtable(){
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

    @RequestMapping("/editiontable")
    public String editiontable(){
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

}
