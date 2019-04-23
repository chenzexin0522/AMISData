package com.amis.controller.reportFrom;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.Presentation;
import com.amis.entity.dto.ReturnPresentationDto;
import com.amis.entity.dto.SelectPresentationClassDTO;
import com.amis.service.PresentationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ClassName PresentationController
 * @Description 报告Controller
 * @Author chenzexin
 * @Date 2019/4/6 22:27
 **/
@RestController
@RequestMapping(value = "presentation")
public class PresentationController {

    @Autowired
    private PresentationService presentationService;

/**
 * @Author chenzexin
 * @Date 2019/4/7 0:23
 * @param presentation
 * @return com.amis.common.ResponseVO
 * @Description     生成班级或学生报告
 **/
    @RequestMapping(value = "insertPresentation",method = RequestMethod.POST)
    public ResponseVO insertPresentation(@RequestBody Presentation presentation) throws Exception {
        if (StringUtils.isBlank(String.valueOf(presentation.getU_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        presentationService.insertPresentation(presentation);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


    /**
     * @Author chenzexin
     * @Date 2019/4/7 1:23
     * @param presentation
     * @return com.amis.common.ResponseVO
     * @Description     查询指定用户已生成报告列表
     **/
    @RequestMapping(value = "selectPresentationList",method = RequestMethod.POST)
    public ResponseVO selectPresentationList(@RequestBody Presentation presentation) throws Exception {
        if (StringUtils.isBlank(String.valueOf(presentation.getU_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        List<ReturnPresentationDto> returnPresentationDtos = presentationService.selectPresentationList(presentation.getU_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnPresentationDtos);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/8 11:09
     * @param presentation
     * @return com.amis.common.ResponseVO
     * @Description        查询报告详情
     **/
    @RequestMapping(value = "selectPresentationDetails",method = RequestMethod.POST)
    public ResponseVO selectPresentationDetails(@RequestBody Presentation presentation) throws Exception {
        if (StringUtils.isBlank(String.valueOf(presentation.getU_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        SelectPresentationClassDTO selectPresentationClassDTO = presentationService.selectPresentationDetails(presentation.getPr_id(),presentation.getType());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(selectPresentationClassDTO);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/19 12:09
     * @param presentation
     * @return com.amis.common.ResponseVO
     * @Description        删除单条报告
     **/
    @RequestMapping(value = "deletePresentation",method = RequestMethod.POST)
    public ResponseVO deletePresentation(@RequestBody Presentation presentation) throws AmisException {
        if (presentation.getPr_id() == 0 ) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        int os = presentationService.deletePresentation(presentation.getPr_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }


}
