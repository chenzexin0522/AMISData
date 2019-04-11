package com.amis.controller.reportFrom;

import com.amis.common.ResponseVO;
import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.entity.TotalTrain;
import com.amis.entity.dto.ClassTrainTabDTO;
import com.amis.entity.dto.QueryClassReportDTO;
import com.amis.entity.dto.ReturnTotalList;
import com.amis.entity.dto.StudentTrainTab;
import com.amis.service.FromListService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName FromList
 * @Description 报表列表查询
 * @Author chenzexin
 * @Date 2019/4/2 18:53
 **/
@RestController
@RequestMapping(value = "reportFrom")
public class FromList {

    @Autowired
    private FromListService fromListService;

    /**
     * @Author chenzexin
     * @Date 2019/4/2 19:13
     * @param totalTrain
     * @return com.amis.common.ResponseVO
     * @Description        查询训练报告集合
     **/
    @RequestMapping(value = "selectFromList",method = RequestMethod.POST)
    public ResponseVO selectFromList(@RequestBody TotalTrain totalTrain) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(totalTrain.getU_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        List<ReturnTotalList> returnTotalLists = fromListService.selectFromList(totalTrain.getU_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnTotalLists);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/6 20:57
     * @param totalTrain
     * @return com.amis.common.ResponseVO
     * @Description        查询单次报告详情
     **/
    @RequestMapping(value = "selectTotalTab",method = RequestMethod.POST)
    public ResponseVO selectTotalTab(@RequestBody TotalTrain totalTrain) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(totalTrain.getU_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ClassTrainTabDTO returnTotalLists = fromListService.selectTotalTab(totalTrain.getTt_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(returnTotalLists);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/6 21:41
     * @param totalTrain
     * @return com.amis.common.ResponseVO
     * @Description        查询学生训练详情
     **/
    @RequestMapping(value = "selectStudentTab",method = RequestMethod.POST)
    public ResponseVO selectStudentTab(@RequestBody TotalTrain totalTrain) throws AmisException {
        if (StringUtils.isBlank(String.valueOf(totalTrain.getU_id()))){
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        StudentTrainTab selectStudentTab = fromListService.selectStudentTab(totalTrain.getTr_id());
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(selectStudentTab);
        return responseVO;
    }



    /**
     * @Author chenzexin
     * @Date 2019/4/3 14:21
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        按时间阶段查询班级训练报告
     **/
    @RequestMapping(value = "queryClassReport",method = RequestMethod.POST)
    public ResponseVO queryClassReport(@RequestBody QueryClassReportDTO queryClassReportDTO) throws AmisException {
        if (queryClassReportDTO.getTc_id() == 0 || queryClassReportDTO.getU_id() == 0) {
            throw new AmisException(MessageKey.PARAMETER_ERROR);
        }
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(null);
        return responseVO;
    }
}
