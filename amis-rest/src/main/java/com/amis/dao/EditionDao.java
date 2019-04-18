package com.amis.dao;

import com.amis.entity.Edition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @InterfaceName EditionDao
 * @Description 版本
 * @Author chenzexin
 * @Date 2019/4/15 16:43
 **/
@Mapper
public interface EditionDao {
    void photoUpload(@Param("path") String path, @Param("u_id") int u_id);

    void modelUpload(String path);

    int selectModelCount();

    void editionUpgrade(Edition edition);

    Edition getEdition();
}
