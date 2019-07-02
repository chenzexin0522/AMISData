package com.amis.dao;

import com.amis.entity.Presentation;
import com.amis.entity.dto.ReturnPresentationDto;
import com.amis.entity.dto.SelectPresentationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<ReturnPresentationDto> selectPresentationList(@Param("u_id") int u_id, @Param("tab_presentation") String tab_presentation);

    List<SelectPresentationDTO> selectPresentationDetails(@Param("pr_id")int pr_id, @Param("tab_presentation") String tab_presentation, @Param("tab_total_train") String tab_total_train, @Param("tab_result") String tab_result);

    List<SelectPresentationDTO> selectPresentationStudent(@Param("pr_id")int pr_id, @Param("tab_presentation") String tab_presentation, @Param("tab_total_train") String tab_total_train, @Param("tab_result") String tab_result);

    int deletePresentation(@Param("pr_id")int pr_id, @Param("tab_presentation") String tab_presentation);
}
