package com.amis.service.impl;

import com.amis.dao.ExcelImportDao;
import com.amis.entity.ImportData;
import com.amis.entity.dto.ExeclTotalNumber;
import com.amis.entity.dto.ExeclTuanTotalNumber;
import com.amis.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExcelImportServiceImpl
 * @Description
 * @Author chenzexin
 * @Date 2019/8/22 11:01
 **/
@Service
public class ExcelImportServiceImpl implements ExcelImportService {

    @Autowired
    private ExcelImportDao excelImportDao;

    @Override
    public int insertExcel(List<ImportData> importDatas) {
        return excelImportDao.insertExcel(importDatas);
    }

    @Override
    public List<ExeclTotalNumber> selectTotalNumber() {
        return excelImportDao.selectTotalNumber();
    }

    @Override
    public void truncateTable() {
        excelImportDao.truncateTable();
    }

    @Override
    public List<ExeclTuanTotalNumber> selectTuanTotalNumber() {
        return excelImportDao.selectTuanTotalNumber();
    }

    @Override
    public List<ImportData> selectexeclUserDatas() {
        return excelImportDao.selectexeclUserDatas();
    }
}
