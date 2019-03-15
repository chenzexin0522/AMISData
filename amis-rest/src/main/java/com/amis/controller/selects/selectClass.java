package com.amis.controller.selects;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.ClassEntity;
import com.amis.service.SelectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @ClassName selectClass
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 15:55
 **/
@RestController
@RequestMapping(value = "select")
public class selectClass {

    @Autowired
    private SelectService selectService;

    /**
     * @Author chenzexin
     * @Date 2019/3/12 16:36
     * @param u_id
     * @return com.amis.common.ResponseVO
     * @Description
     **/
    @RequestMapping(value = "selectClass",method = RequestMethod.POST)
    public ResponseVO selectClass(@RequestParam("id")String u_id ) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(u_id))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ClassEntity classEntity = selectService.selectClass(u_id);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(classEntity);
        return responseVO;
    }

}
