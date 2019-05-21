package com.amis.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "/test/login";
    }
}
