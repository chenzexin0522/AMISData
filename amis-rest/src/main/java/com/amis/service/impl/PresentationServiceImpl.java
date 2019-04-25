package com.amis.service.impl;

import com.amis.common.exception.AmisException;
import com.amis.common.exception.MessageKey;
import com.amis.dao.PresentationDao;
import com.amis.entity.Presentation;
import com.amis.entity.dto.ReturnPresentationDto;
import com.amis.entity.dto.SelectPresentationClassDTO;
import com.amis.entity.dto.SelectPresentationDTO;
import com.amis.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName PresentationServiceImpl
 * @Description 报告ServiceImpl
 * @Author chenzexin
 * @Date 2019/4/6 22:29
 **/
@Service
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    private PresentationDao presentationDao;

    @Override
    public void insertPresentation(Presentation presentation) throws Exception {
        String start_time = presentation.getStart_time();
        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd");
        Date starttime = start.parse(start_time);
        String end_time = presentation.getEnd_time();
        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd");
        Date endtime = end.parse(end_time);
        if (start_time == end_time){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,1);
            String date2= sdf.format(calendar.getTime());
            presentation.setEnd_time(date2);
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        presentation.setInsert_time(sdf.format(d));
        int a = presentationDao.insertPresentation(presentation);
        if (a == 0){
            throw new AmisException(MessageKey.DB_OPERATIONE_FAIL);
        }
    }

    @Override
    public List<ReturnPresentationDto> selectPresentationList(int u_id) {
        List<ReturnPresentationDto> returnPresentationDtos = presentationDao.selectPresentationList(u_id);
        return returnPresentationDtos;
    }

    @Override
    public SelectPresentationClassDTO selectPresentationDetails(int pr_id,int type) {
        List<SelectPresentationDTO> selectPresentationDTO = new ArrayList<>();
        List total_rateList = new ArrayList();
        List one_rateList = new ArrayList();
        List two_rateList = new ArrayList();
        List three_rateList = new ArrayList();
        List four_rateList = new ArrayList();
        if (type == 0){
             selectPresentationDTO = presentationDao.selectPresentationDetails(pr_id);
        }else if (type == 1){
           selectPresentationDTO = presentationDao.selectPresentationStudent(pr_id);
        }
            SelectPresentationClassDTO selectPresentationClassDTO = new SelectPresentationClassDTO();
            double total = 0;
            double total_one = 0;
            double total_two = 0;
            double total_three = 0;
            double total_four = 0;
            int size = selectPresentationDTO.size();
            for (SelectPresentationDTO sele : selectPresentationDTO) {
                total = total + sele.getTotal_completion_rate();
                total_one = total_one + sele.getOne_completion_rate();
                total_two = total_two + sele.getTwo_completion_rate();
                total_three = total_three + sele.getThree_completion_rate();
                total_four = total_four + sele.getFour_completion_rate();
                total_rateList.add(sele.getTotal_completion_rate());
                one_rateList.add(sele.getOne_completion_rate());
                two_rateList.add(sele.getTwo_completion_rate());
                three_rateList.add(sele.getThree_completion_rate());
                four_rateList.add(sele.getFour_completion_rate());
            }
            selectPresentationClassDTO.setTrainCount(size);
            selectPresentationClassDTO.setTotal_completion_rate((double) Math.round(total/size * 100) / 100);
            selectPresentationClassDTO.setOne_completion_rate((double) Math.round(total_one/size * 100) / 100);
            selectPresentationClassDTO.setTwo_completion_rate((double) Math.round(total_two/size * 100) / 100);
            selectPresentationClassDTO.setThree_completion_rate((double) Math.round(total_three/size * 100) / 100);
            selectPresentationClassDTO.setFour_completion_rate((double) Math.round(total_four/size * 100) / 100);
            selectPresentationClassDTO.setTotal_rateList(total_rateList);
            selectPresentationClassDTO.setOne_rateList(one_rateList);
            selectPresentationClassDTO.setTwo_rateList(two_rateList);
            selectPresentationClassDTO.setThree_rateList(three_rateList);
            selectPresentationClassDTO.setFour_rateList(four_rateList);
            return selectPresentationClassDTO;
    }

    @Override
    public int deletePresentation(int pr_id) {
        return presentationDao.deletePresentation(pr_id);
    }
}
