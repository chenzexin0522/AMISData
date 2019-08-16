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

//    @RequestMapping("/MontionDemo")
//    public String MontionDemo(){
//        return "indexWebSocket";
//    }

    @RequestMapping(value = "/getMontionDataTable")
    @ResponseBody
    public List<float[]> getMontionDataTable(Model model) {
        return ReceiveDataServiceImpl.dataListStatic;
    }



    @RequestMapping("/getMontionDataViewDong")
    public String getMontionDataViewDong(){
        return "montionDataViewDong";
    }

//    public static ReslutMontionData xuNi(){
//        ReslutMontionData reslutMontionData = new ReslutMontionData();
//        reslutMontionData.setMac("80:EA:CA:00:19:48");
//        reslutMontionData.setAx(suiji());
//        reslutMontionData.setAy(suiji());
//        reslutMontionData.setAz(suiji());
//        reslutMontionData.setGx(suiji());
//        reslutMontionData.setGy(suiji());
//        reslutMontionData.setGz(suiji());
//        return reslutMontionData;
//    }
//
//    //虚拟数据随机一个48位长度的int数组
//    public static Integer[] suiji(){
//        Integer[] dems = new Integer[48];
//        Random rand = new Random();
//        for (int i = 0; i <dems.length; i++){
//            dems[i] = rand.nextInt(100);
//        }
//        return dems;
//    }



}
