package com.amis.service.impl;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.dao.TotalTrainDao;
import com.amis.entity.TabResult;
import com.amis.entity.TotalTrain;
import com.amis.service.TotalTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName TotalTrainServiceImpl
 * @Description 训练
 * @Author chenzexin
 * @Date 2019/3/12 20:38
 **/
@Service
public class TotalTrainServiceImpl implements TotalTrainService {

    @Autowired
    private TotalTrainDao totalTrainDao;

    /**
     * @Author chenzexin
     * @Date 2019/3/13 11:37
     * @param totalTrain
     * @return int
     * @Description        插入总训练信息-插入学生个人训练信息
     **/
    @Override
    public ResponseVO insertTrain(TotalTrain totalTrain) {
        ResponseVO responseVO;
        int to = totalTrainDao.insertTrain(totalTrain);
        if (to == 0){
            responseVO=new ResponseVO(MessageKey.INSERT_FAIL);
            return responseVO;
        }
        List<TabResult> tabResultsList = totalTrain.getTabResultsList();
        for (TabResult tabResult : tabResultsList) {
            tabResult.setTc_id(totalTrain.getTc_id());
            tabResult.setTt_id(totalTrain.getTt_id());
        }
        totalTrainDao.insertTabResultList(tabResultsList);
        responseVO=new ResponseVO(MessageKey.RETURN_OK);        //设置返回类型
        responseVO.setId(totalTrain.getTt_id());
        return responseVO;
    }


    @Override
    public ResponseVO insertTrainAlone(TotalTrain totalTrain) {
        ResponseVO responseVO;
        int to = totalTrainDao.insertTrain(totalTrain);
        if (to == 0){
            responseVO=new ResponseVO(MessageKey.INSERT_FAIL);
            return responseVO;
        }
        responseVO=new ResponseVO(MessageKey.RETURN_OK);        //设置返回类型
        responseVO.setId(totalTrain.getTt_id());
        return responseVO;
    }

    @Override
    public ResponseVO insertStudentTrainAlone(TotalTrain totalTrain) {
        ResponseVO responseVO;
        List<TabResult> tabResult = totalTrain.getTabResultsList();
        for (TabResult tabResult1 : tabResult) {
            tabResult1.setTt_id(totalTrain.getTt_id());
            tabResult1.setTc_id(totalTrain.getTc_id());
        }
        int as = totalTrainDao.insertTabResultList(tabResult);
        if (as == 0){
            responseVO=new ResponseVO(MessageKey.INSERT_FAIL);
            return responseVO;
        }
         totalTrainDao.updateTrainType(totalTrain);
        responseVO=new ResponseVO(MessageKey.RETURN_OK);        //设置返回类型
        responseVO.setId(totalTrain.getTt_id());
        return responseVO;
    }

    @Override
    public ResponseVO updateTrainAlone(TotalTrain totalTrain) {
        ResponseVO responseVO;
        int to = totalTrainDao.updateTrainAlone(totalTrain);
        if (to == 0){
            responseVO=new ResponseVO(MessageKey.UPDATE_FAIL);
            return responseVO;
        }
        responseVO=new ResponseVO(MessageKey.RETURN_OK);        //设置返回类型
        responseVO.setId(totalTrain.getTt_id());
        return responseVO;
    }

    @Override
    public int deleteTrain(int tt_id) {
        return totalTrainDao.deleteTrain(tt_id);
    }
}
