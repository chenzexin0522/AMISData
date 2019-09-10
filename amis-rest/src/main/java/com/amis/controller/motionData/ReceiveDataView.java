package com.amis.controller.motionData;

import com.amis.entity.dto.GradeDTO;
import com.amis.entity.dto.ReslutMontionData;
import com.amis.service.RestAdminService;
import com.amis.service.impl.ReceiveDataServiceImpl;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.FastArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName ReceiveDataView
 * @Description web页面实时显示数据view
 * @Author chenzexin
 * @Date 2019/8/13 9:59
 **/

@Controller
@RequestMapping(value = "montion")
public class ReceiveDataView {

    @Autowired
    private RestAdminService restAdminService;

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




}
