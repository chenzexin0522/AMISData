package com.amis.service;

import com.amis.entity.ImportData;
import com.amis.entity.dto.ExeclTotalNumber;
import com.amis.entity.dto.ExeclTuanTotalNumber;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @InterfaceName ExcelImportService
 * @Description
 * @Author chenzexin
 * @Date 2019/8/22 10:58
 **/

@Service
public interface ExcelImportService {


    int insertExcel(List<ImportData> importDatas);

    List<ExeclTotalNumber> selectTotalNumber();

    void truncateTable();

    List<ExeclTuanTotalNumber> selectTuanTotalNumber();

    List<ImportData> selectexeclUserDatas();
}
