package com.amis.controller.admin;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.common.md5.MD5Config;
import com.amis.entity.*;
import com.amis.entity.dto.EquipmentDTO;
import com.amis.entity.dto.FeedbackDTO;
import com.amis.entity.dto.ReturnCoachDTO;
import com.amis.service.RestAdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RestAdminController
 * @Description 后台管理
 * @Author chenzexin
 * @Date 2019/4/17 10:38
 **/
@RestController
@RequestMapping(value = "admin")
public class RestAdminController {

    @Autowired
    private RestAdminService restAdminService;

    /**
     * @Author chenzexin
     * @Date 2019/4/17 17:59
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        查询版本列表
     **/
    @RequestMapping(value = "selectEditionList",method = RequestMethod.POST)
    public ResponseVO selectEditionList() {
        List<Edition> editions = restAdminService.selectEditionList();
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(editions);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 18:25
     * @param edition
     * @return com.amis.common.ResponseVO
     * @Description        删除版本
     **/
    @RequestMapping(value = "deleteEdition",method = RequestMethod.POST)
    public ResponseVO deleteEdition(@RequestBody Edition edition){
        int or = restAdminService.deleteEdition(edition.getTet_id());
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 18:26
     * @param edition
     * @return com.amis.common.ResponseVO
     * @Description        修改版本信息
     **/
    @RequestMapping(value = "updateEdition",method = RequestMethod.POST)
    public ResponseVO updateEdition(@RequestBody Edition edition){
        int or = restAdminService.updateEdition(edition);
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.UPDATE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:08
     * @param admin
     * @return com.amis.common.ResponseVO
     * @Description        管理员登录
     **/
    @RequestMapping(value = "adminlogin",method = RequestMethod.POST)
    public ResponseVO adminlogin(@RequestBody Admin admin){
        if (StringUtils.isBlank(admin.getAd_phone()) && StringUtils.isBlank(admin.getAd_password())){
            ResponseVO responseVO = new ResponseVO(MessageKey.PHOME_NUMBER_OR_PASSWORD_ERROR);
            return responseVO;
        }
        Admin admins = restAdminService.adminlogin(admin);
        if (admins == null){
            ResponseVO responseVO = new ResponseVO(MessageKey.SELECT_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(admins);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:35
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        查询所有学校
     **/
    @RequestMapping(value = "selectSchoolList",method = RequestMethod.POST)
    public ResponseVO selectSchoolList() {
        School schools = restAdminService.selectSchoolList();
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(schools);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param school
     * @return com.amis.common.ResponseVO
     * @Description        添加学校
     **/
    @RequestMapping(value = "addSchool",method = RequestMethod.POST)
    public ResponseVO addSchool(@RequestBody School school){
        int or = restAdminService.addSchool(school);
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param school
     * @return com.amis.common.ResponseVO
     * @Description        修改学校
     **/
    @RequestMapping(value = "updateSchool",method = RequestMethod.POST)
    public ResponseVO updateSchool(@RequestBody  School school){
        int or = restAdminService.updateSchool(school);
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.UPDATE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:35
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        查询所有教练
     **/
    @RequestMapping(value = "selectCoachList",method = RequestMethod.POST)
    public ResponseVO selectCoachlList() {
        List<ReturnCoachDTO> returnCoachDTOS = restAdminService.selectCoachlList();
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnCoachDTOS);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        添加教练
     **/
    @RequestMapping(value = "addCoach",method = RequestMethod.POST)
    public ResponseVO addCoach(@RequestBody Users users){
        users.setU_password(MD5Config.md5Password(users.getU_password()));
        int or = restAdminService.addCoach(users);
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        删除教练
     **/
    @RequestMapping(value = "deleteCoach",method = RequestMethod.POST)
    public ResponseVO deleteCoach(@RequestBody Users users){
        int or = restAdminService.deleteCoach(users.getU_id());
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:35
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        查询所有学生
     **/
    @RequestMapping(value = "selectStudentList",method = RequestMethod.POST)
    public ResponseVO selectStudentList() {
        List<Student> students = restAdminService.selectStudentList();
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(students);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param student
     * @return com.amis.common.ResponseVO
     * @Description        添加学生
     **/
    @RequestMapping(value = "addStudent",method = RequestMethod.POST)
    public ResponseVO addStudent(@RequestBody Student student){
        int or = restAdminService.addStudent(student);
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param student
     * @return com.amis.common.ResponseVO
     * @Description        删除学生
     **/
    @RequestMapping(value = "deleteStudent",method = RequestMethod.POST)
    public ResponseVO deleteStudent(@RequestBody Student student){
        int or = restAdminService.deleteStudent(student.getUc_id());
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:35
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        查询所有设备
     **/
    @RequestMapping(value = "selectEquipmentList",method = RequestMethod.POST)
    public ResponseVO selectEquipmentList() {
        List<EquipmentDTO> equipmentDTOS = restAdminService.selectEquipmentList();
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(equipmentDTOS);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param student
     * @return com.amis.common.ResponseVO
     * @Description        添加设备
     **/
    @RequestMapping(value = "addEquipment",method = RequestMethod.POST)
    public ResponseVO addEquipment(@RequestBody Equipment equipment){
        int or = restAdminService.addEquipment(equipment);
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/17 19:52
     * @param student
     * @return com.amis.common.ResponseVO
     * @Description        删除设备
     **/
    @RequestMapping(value = "deleteEquipment",method = RequestMethod.POST)
    public ResponseVO deleteEquipment(@RequestBody Equipment equipment){
        int or = restAdminService.deleteEquipment(equipment.getTe_id());
        if (or == 0){
            ResponseVO responseVO = new ResponseVO(MessageKey.DELETE_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/19 14:29
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        查询所有反馈
     **/
    @RequestMapping(value = "selectFeedback",method = RequestMethod.POST)
    public ResponseVO selectFeedback(){
        List<FeedbackDTO> feedbackDTOS = restAdminService.selectFeedback();
        if (feedbackDTOS == null || feedbackDTOS.equals(null)){
            ResponseVO responseVO = new ResponseVO(MessageKey.SELECT_FAIL);
            return responseVO;
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(feedbackDTOS);
        return responseVO;
    }


}
