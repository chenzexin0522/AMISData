package com.amis.service;

import com.amis.entity.Edition;

/**
 * @InterfaceName EditionService
 * @Description 版本
 * @Author chenzexin
 * @Date 2019/4/11 16:06
 **/
public interface EditionService {

    void photoUpload(String path, int u_id);

    void modelUpload(String path);

    int selectModelCount();

    void editionUpgrade(Edition edition);

    Edition getEdition();
}
