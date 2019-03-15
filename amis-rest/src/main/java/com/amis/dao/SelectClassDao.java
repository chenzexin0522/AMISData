package com.amis.dao;

import com.amis.entity.ClassEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName SelectClassDao
 * @Description 查询
 * @Author chenzexin
 * @Date 2019/3/12 16:29
 **/
@Mapper
public interface SelectClassDao {
    ClassEntity selectClass(String u_id);
}
