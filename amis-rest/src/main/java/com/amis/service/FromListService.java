package com.amis.service;

import com.amis.entity.dto.ClassTrainTabDTO;
import com.amis.entity.dto.QueryClassReportDTO;
import com.amis.entity.dto.ReturnTotalList;
import com.amis.entity.dto.StudentTrainTab;

import java.util.List;

/**
 * @InterfaceName FromListService
 * @Description 报表列表查询
 * @Author chenzexin
 * @Date 2019/4/2 18:54
 **/
public interface FromListService {
    /**
     * @Author chenzexin
     * @Date 2019/4/2 19:14
     * @param u_id
     * @return java.util.List<com.amis.entity.dto.SelectClassDTO>
     * @Description        查询训练报告集合
     **/
    List<ReturnTotalList> selectFromList(int u_id);

    ClassTrainTabDTO selectTotalTab(int tt_id);

    StudentTrainTab selectStudentTab(int tr_id);
}
