package com.amis.service.impl;

import com.amis.dao.UpdateAllIPDao;
import com.amis.entity.Edition;
import com.amis.service.UpdateAllIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UpdateAllIPServiceImpl
 * @Description
 * @Author chenzexin
 * @Date 2019/5/6 17:26
 **/
@Service
public class UpdateAllIPServiceImpl implements UpdateAllIPService {

    @Autowired
    UpdateAllIPDao updateAllIPDao;

    @Override
    public void updateAPKURL(Edition edition) {
        updateAllIPDao.updateAPKURL(edition);
    }
}
