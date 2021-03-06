package com.amis.controller.motionData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ReceiveDataView
 * @Description web页面实时显示数据view
 * @Author chenzexin
 * @Date 2019/8/13 9:59
 **/

@Controller
@RequestMapping(value = "montion")
public class ReceiveDataView {
    /**
     * @Author chenzexin
     * @Date 2019/5/31 10:09
     * @param
     * @return java.lang.String
     * @Description        查看手环实时数据view
     **/
    @RequestMapping("/getMontionData")
    public String getMontionData(){
        return "montionDataView";
    }


    @RequestMapping("/getMontionDataViewDong")
    public String getMontionDataViewDong(){
        return "montionDataViewDong";
    }

    @RequestMapping("/motionDataDemoView")
    public String motionDataDemoView(){
        return "motionDataDemoView";
    }

    @RequestMapping("/exportSwimmingData")
    public String exportSwimmingData(){
        return "motionDataDemoView";
    }

    @RequestMapping("/selectMontionData")
    public String selectMontionData(){
        return "selectMontionData";
    }


}
