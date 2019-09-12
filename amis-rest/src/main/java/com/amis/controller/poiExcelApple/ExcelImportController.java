package com.amis.controller.poiExcelApple;
import com.amis.entity.ImportData;
import com.amis.entity.dto.ExeclTotalNumber;
import com.amis.entity.dto.ExeclTuanTotalNumber;
import com.amis.service.ExcelImportService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "importExcel")
public class ExcelImportController {

    @Autowired
    private ExcelImportService excelImportService;


    /**
     * @Author chenzexin
     * @Date 2019/9/12 18:07
     * @param request
     * @return java.lang.String
     * @Description        
     **/
    @RequestMapping(value = "/toHtml")
    String test(HttpServletRequest request) {
        return "request";
    }

//处理文件上传
    @ResponseBody//返回json数据
    @RequestMapping(value = "/excelImport", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            return "文件为空！";
        }
        try {
//根据路径获取这个操作excel的实例
            HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());
            //根据页面index 获取sheet页
            HSSFSheet sheet = wb.getSheetAt(0);
//实体类集合
            List<ImportData> importDatas = new ArrayList<>();
            HSSFRow row = null;
//循环sesheet页中数据从第二行开始，第一行是标题
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
//获取每一行数据
                row = sheet.getRow(i);
                ImportData data = new ImportData();
                data.setShangPinName(row.getCell(11).getStringCellValue());
                data.setShangPinNumber(Integer.valueOf((int) row.getCell(13).getNumericCellValue()));
                data.setShangPinMoney(row.getCell(14).getNumericCellValue());
                data.setZhuangTai(row.getCell(22).getStringCellValue());
                data.setTuanZhangName(row.getCell(31).getStringCellValue());
                DecimalFormat df = new DecimalFormat("#");
                data.setTuanZhangPhone(df.format(row.getCell(32).getNumericCellValue()));
                data.setTuanZhangDiZhi(row.getCell(33).getStringCellValue());
                importDatas.add(data);
            }
            excelImportService.truncateTable();
            int yAndNo = excelImportService.insertExcel(importDatas);
            List<ExeclTotalNumber> execlTotalNumbers = new ArrayList<>();
            List<ExeclTuanTotalNumber> execlTuanTotalNumbers = new ArrayList<>();
            if (yAndNo != 0){
                execlTotalNumbers = excelImportService.selectTotalNumber();
                execlTuanTotalNumbers = excelImportService.selectTuanTotalNumber();
            }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheets = workbook.createSheet("单品统计");
            HSSFSheet sheetTuan = workbook.createSheet("团长统计");
            createTitle(workbook,sheets,1);
            createTitle(workbook,sheetTuan,2);
            //设置日期格式
            HSSFCellStyle style = workbook.createCellStyle();
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
            //新增数据行，并且设置单元格数据
            int rowNum=1;
            for(ExeclTotalNumber execlTotalNumber:execlTotalNumbers){
                HSSFRow rowas = sheets.createRow(rowNum);
                rowas.createCell(0).setCellValue(execlTotalNumber.getShangPinName());
                rowas.createCell(1).setCellValue(execlTotalNumber.getShangPinNumber());
                rowNum++;
            }
            int rowNumTuan=1;
            for(ExeclTuanTotalNumber execlTuanTotalNumber:execlTuanTotalNumbers){
                HSSFRow rowas = sheetTuan.createRow(rowNumTuan);
                rowas.createCell(0).setCellValue(execlTuanTotalNumber.getShangPinName());
                rowas.createCell(1).setCellValue(execlTuanTotalNumber.getShangPinNumber());
                rowas.createCell(2).setCellValue(execlTuanTotalNumber.getTuanZhangName());
                rowNumTuan++;
            }
            String fileNameas = "单品统计-"+fileName;
            //生成excel文件
            buildExcelFile(fileNameas, workbook);
            //浏览器下载excel
            buildExcelDocument(fileNameas,workbook,response);
            return "download excel";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导入成功!";
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


    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet, int a){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0,42*256);
        sheet.setColumnWidth(1,17*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        HSSFCell cell;
        if (a == 1 ){
            cell = row.createCell(0);
            cell.setCellValue("商品名称");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("商品总销量");
            cell.setCellStyle(style);
        }else if (a ==2){
            cell = row.createCell(0);
            cell.setCellValue("商品名称");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("商品总销量");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("团长名称");
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
}