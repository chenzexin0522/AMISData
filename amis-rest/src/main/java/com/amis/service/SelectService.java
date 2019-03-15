package com.amis.service;

import com.amis.entity.ClassEntity;

/**
 * @InterfaceName SelectService
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 16:25
 **/
public interface SelectService {

    ClassEntity selectClass(String u_id);
}
