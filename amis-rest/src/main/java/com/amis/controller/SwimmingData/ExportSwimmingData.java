package com.amis.controller.SwimmingData;
import com.amis.entity.MotionDataEntity;
import com.amis.entity.dto.*;
import com.amis.service.SwimmingDataService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;


@Controller
@RequestMapping(value = "exportSwimming")
public class ExportSwimmingData {

    @Autowired
    private SwimmingDataService swimmingDataService;


    @RequestMapping(value = "/deleteExcelView")
    String test(HttpServletRequest request) {
        return "exportSwimming";
    }

    @RequestMapping(value = "/deleteDBData")
    String deleteDBData(HttpServletRequest request,HttpServletResponse response) {
        swimmingDataService.truncateTable();
        return "exportSwimming";
    }



    @ResponseBody//返回json数据
    @RequestMapping(value = "/excelImport", method = RequestMethod.POST)
    public String getSwimmingDataExcel(HttpServletResponse response,HttpServletRequest request) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("游泳数据");
        createTitle(workbook,sheet,1);
        //查询出所有的游泳数据
        List<MotionDataEntity> rows = swimmingDataService.getSwimmingDataExcel();
        //解析数据
        List<ReturnSwimmingDataDTO> returnSwimmingDataDTOS = swimmingDataService.analysisMotionDataEntity(rows);
        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(ReturnSwimmingDataDTO returnSwimmingDataDTO:returnSwimmingDataDTOS){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(returnSwimmingDataDTO.getMac());
            row.createCell(1).setCellValue(returnSwimmingDataDTO.getAx());
            row.createCell(2).setCellValue(returnSwimmingDataDTO.getAy());
            row.createCell(3).setCellValue(returnSwimmingDataDTO.getAz());
            row.createCell(4).setCellValue(returnSwimmingDataDTO.getGx());
            row.createCell(5).setCellValue(returnSwimmingDataDTO.getGy());
            row.createCell(6).setCellValue(returnSwimmingDataDTO.getGz());
            rowNum++;
        }
        String fileName = "游泳数据.xls";
        //生成excel文件
        buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
    }

    //创建表头
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet, int a){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(2,12*256);
        sheet.setColumnWidth(3,12*256);
        sheet.setColumnWidth(4,12*256);
        sheet.setColumnWidth(5,12*256);
        sheet.setColumnWidth(6,12*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        HSSFCell cell;
        if (a == 1 ){
            cell = row.createCell(0);
            cell.setCellValue("mac");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("Ax");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("Ay");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("Az");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("Gx");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("Gy");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("Gz");
            cell.setCellStyle(style);

        }

    }


    //生成excel文件
    protected void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    //浏览器下载excel
    protected void buildExcelDocument(String filename,HSSFWorkbook workbook,HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


}