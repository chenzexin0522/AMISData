package com.amis.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ShowView
 * @Description
 * @Author chenzexin
 * @Date 2019/5/21 18:41
 **/
@Controller
public class ShowView {
    @RequestMapping("")
    public String logins(){
        return "login";
    }



}
