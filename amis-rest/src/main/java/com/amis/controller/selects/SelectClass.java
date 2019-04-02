package com.amis.controller.selects;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.ClassEntity;
import com.amis.entity.Users;
import com.amis.entity.dto.SelectClassDTO;
import com.amis.entity.dto.SelectCoachDTO;
import com.amis.entity.dto.SelectStudentDTO;
import com.amis.service.SelectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 15:55
 **/
@RestController
@RequestMapping(value = "select")
public class SelectClass {

    @Autowired
    private SelectService selectService;

    /**
     * @Author chenzexin
     * @Date 2019/3/12 16:36
     * @param  classEntity
     * @return com.amis.common.ResponseVO
     * @Description 根据学校id查询学校旗下所有班级
     **/
    @RequestMapping(value = "selectClass",method = RequestMethod.POST)
    public ResponseVO selectClass(@RequestBody ClassEntity classEntity) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(classEntity.getS_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        List<SelectClassDTO> returnclassEntity = selectService.selectClass(classEntity.getS_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnclassEntity);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/2 13:57
     * @param classEntity
     * @return com.amis.common.ResponseVO
     * @Description        根据学校id查询学校旗下所有教练
     **/
    @RequestMapping(value = "selectCoach",method = RequestMethod.POST)
    public ResponseVO selectCoach(@RequestBody ClassEntity classEntity) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(classEntity.getS_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        List<SelectCoachDTO> returnCoach = selectService.selectCoach(classEntity.getS_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnCoach);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/2 14:53
     * @param users
     * @return com.amis.common.ResponseVO
     * @Description        根据教练id查询教练所受教的所有班级
     **/
    @RequestMapping(value = "coachSelectClass",method = RequestMethod.POST)
    public ResponseVO coachSelectClass(@RequestBody Users users) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(users.getU_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        List<SelectClassDTO> returnClass = selectService.coachSelectClass(users.getU_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnClass);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/2 15:10
     * @param classEntity
     * @return com.amis.common.ResponseVO
     * @Description        根据班级id查询班级下所有学生
     **/
    @RequestMapping(value = "selectStudent",method = RequestMethod.POST)
    public ResponseVO selectStudent(@RequestBody ClassEntity classEntity) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(classEntity.getTc_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        List<SelectStudentDTO> returnCoach = selectService.selectStudent(classEntity.getTc_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnCoach);
        return responseVO;
    }



}
