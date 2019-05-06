package com.amis.service.impl;

import com.amis.dao.EditionDao;
import com.amis.entity.Edition;
import com.amis.entity.dto.TrainLog;
import com.amis.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName EditionServiceImpl
 * @Description 版本业务层
 * @Author chenzexin
 * @Date 2019/4/11 16:07
 **/
@Service
public class EditionServiceImpl implements EditionService {

    @Autowired
    private EditionDao editionDao;

    @Override
    public void photoUpload(String path, int u_id) {
        editionDao.photoUpload(path,u_id);
    }

    @Override
    public void modelUpload(String path) {
        editionDao.modelUpload(path);
    }

    @Override
    public int selectModelCount() {
        return editionDao.selectModelCount();
    }

    @Override
    public void editionUpgrade(Edition edition) {
       editionDao.editionUpgrade(edition);
    }

    @Override
    public Edition getEdition() {
        return editionDao.getEdition();
    }

    @Override
    public void trainLogUpload(TrainLog trainLog) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        trainLog.setInsertTime(sdf.format(d));
        editionDao.trainLogUpload(trainLog);
    }

}
