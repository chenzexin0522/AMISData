package com.amis.service.impl;

import com.amis.dao.SelectClassDao;
import com.amis.entity.ClassEntity;
import com.amis.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SelectServiceImpl
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 16:26
 * @Description
 **/
@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectClassDao selectClassDao;

    @Override
    public ClassEntity selectClass(String u_id) {
        return selectClassDao.selectClass(u_id);
    }
}
