package com.amis.service.impl;

import com.amis.dao.FromListDao;
import com.amis.entity.dto.*;
import com.amis.service.FromListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName FromListServiceImpl
 * @Description 报表列表查询
 * @Author chenzexin
 * @Date 2019/4/2 18:55
 **/
@Service
public class FromListServiceImpl implements FromListService {

    @Autowired
    private FromListDao fromListDao;

    @Override
    public List<ReturnTotalList> selectFromList(int u_id) {
        List<ReturnTotalList> selectFromListDTOS = fromListDao.selectFromList(u_id);
        return selectFromListDTOS;
    }

    @Override
    public ClassTrainTabDTO selectTotalTab(int tt_id) {
        ClassTrainTabDTO classTrainTabDTO = fromListDao.selectTotalTab(tt_id);
        classTrainTabDTO.setStudentTrainLists(fromListDao.selectStudentList(tt_id));
        return classTrainTabDTO;
    }

    @Override
    public StudentTrainTab selectStudentTab(int tr_id) {
        StudentTrainTab studentTrainTab = fromListDao.selectStudentTab(tr_id);
        int ad = 0;
        int completion_rate = 0;
        if (studentTrainTab.getOne_completion_rate() > 0){
            ad++;
            completion_rate = completion_rate+studentTrainTab.getOne_completion_rate();
        }if (studentTrainTab.getTwo_completion_rate() > 0){
            ad++;
            completion_rate = completion_rate+studentTrainTab.getTwo_completion_rate();
        }if (studentTrainTab.getThree_completion_rate() > 0){
            ad++;
            completion_rate = completion_rate+studentTrainTab.getThree_completion_rate();
        }if (studentTrainTab.getFour_completion_rate() > 0){
            ad++;
            completion_rate = completion_rate+studentTrainTab.getFour_completion_rate();
        }
        studentTrainTab.setTotal_comletion_rate(completion_rate/ad);
        return studentTrainTab;
    }

    @Override
    public List<QueryClassReportDTO> queryClassReport(QueryClassReportDTO queryClassReportDTO) {
        return fromListDao.queryClassReport(queryClassReportDTO);
    }

}
