package com.amis.dao;

import com.amis.entity.ImportData;
import com.amis.entity.dto.ExeclTotalNumber;
import com.amis.entity.dto.ExeclTuanTotalNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName ExcelImportDao
 * @Description
 * @Author chenzexin
 * @Date 2019/8/22 11:02
 **/
@Mapper
public interface ExcelImportDao {
    int insertExcel(@Param("importDatas") List<ImportData> importDatas);

    List<ExeclTotalNumber> selectTotalNumber();

    void truncateTable();

    List<ExeclTuanTotalNumber> selectTuanTotalNumber();

    List<ImportData> selectexeclUserDatas();
}
