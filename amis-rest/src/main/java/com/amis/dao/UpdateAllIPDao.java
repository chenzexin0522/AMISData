package com.amis.dao;

import com.amis.entity.Edition;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName UpdateAllIPDao
 * @Description
 * @Author chenzexin
 * @Date 2019/5/6 18:20
 **/
@Mapper
public interface UpdateAllIPDao {
    void updateAPKURL(Edition edition);
}
