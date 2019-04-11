package com.amis.dao;

import com.amis.entity.Presentation;
import com.amis.entity.dto.ReturnPresentationDto;
import com.amis.entity.dto.SelectPresentationDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName PresentationDao
 * @Description 报告Dao
 * @Author chenzexin
 * @Date 2019/4/6 22:29
 **/
@Mapper
public interface PresentationDao {
    int insertPresentation(Presentation presentation);

    List<ReturnPresentationDto> selectPresentationList(int u_id);

    List<SelectPresentationDTO> selectPresentationDetails(int pr_id);

    List<SelectPresentationDTO> selectPresentationStudent(int pr_id);
}
