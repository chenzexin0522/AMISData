package com.amis.service;

import com.amis.entity.Presentation;
import com.amis.entity.dto.ReturnPresentationDto;
import com.amis.entity.dto.SelectPresentationClassDTO;

import java.util.List;

/**
 * @InterfaceName PresentationService
 * @Description 报告Service
 * @Author chenzexin
 * @Date 2019/4/6 22:28
 **/

public interface PresentationService {

    void insertPresentation(Presentation presentation) throws Exception;

    List<ReturnPresentationDto> selectPresentationList(int u_id);

    SelectPresentationClassDTO selectPresentationDetails(int pr_id,int type);
}
