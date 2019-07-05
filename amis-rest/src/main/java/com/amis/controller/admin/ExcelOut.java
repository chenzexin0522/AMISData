package com.amis.controller.admin;

import com.amis.entity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.amis.service.RestAdminService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ClassName ExcelOut
 * @Description
 * @Author chenzexin
 * @Date 2019/5/13 17:54
 **/


@RestController
@RequestMapping(value = "/excel")
public class ExcelOut {
    @Autowired
    private RestAdminService userService;

    //创建表头
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet, int a){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(2,17*256);
        sheet.setColumnWidth(3,19*256);
        sheet.setColumnWidth(4,19*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        HSSFCell cell;
        if (a == 1 ){
            cell = row.createCell(0);
            cell.setCellValue("学生ID");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("学生昵称");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("学生手机号");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("学生设备mac");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("学生班级");
            cell.setCellStyle(style);
        }else if (a == 2){
            cell = row.createCell(0);
            cell.setCellValue("教练ID");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("教练昵称");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("教练手机号");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("教练教龄");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("教龄称号");
            cell.setCellStyle(style);
        }else if (a == 3){
            cell = row.createCell(0);
            cell.setCellValue("班级ID");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("班级昵称");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("班级人数");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("归属教练");
            cell.setCellStyle(style);
        }else if(a == 4){
            cell = row.createCell(0);
            cell.setCellValue("训练开始时间");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("训练结束时间");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("动作1完成率");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("动作2完成率");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("动作3完成率");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("动作4完成率");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("平均完成率");
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue("动作1设置值");
            cell.setCellStyle(style);

            cell = row.createCell(8);
            cell.setCellValue("动作2设置值");
            cell.setCellStyle(style);

            cell = row.createCell(9);
            cell.setCellValue("动作3设置值");
            cell.setCellStyle(style);

            cell = row.createCell(10);
            cell.setCellValue("动作4设置值");
            cell.setCellStyle(style);

            cell = row.createCell(11);
            cell.setCellValue("动作1完成值");
            cell.setCellStyle(style);

            cell = row.createCell(12);
            cell.setCellValue("动作2完成值");
            cell.setCellStyle(style);

            cell = row.createCell(13);
            cell.setCellValue("动作3完成值");
            cell.setCellStyle(style);

            cell = row.createCell(14);
            cell.setCellValue("动作4完成值");
            cell.setCellStyle(style);

            cell = row.createCell(15);
            cell.setCellValue("动作1-速度");
            cell.setCellStyle(style);

            cell = row.createCell(16);
            cell.setCellValue("动作1-频率");
            cell.setCellStyle(style);

            cell = row.createCell(17);
            cell.setCellValue("动作1-旋转");
            cell.setCellStyle(style);

            cell = row.createCell(18);
            cell.setCellValue("动作1-流畅度");
            cell.setCellStyle(style);

            cell = row.createCell(19);
            cell.setCellValue("动作1-力量");
            cell.setCellStyle(style);

            cell = row.createCell(20);
            cell.setCellValue("动作2-速度");
            cell.setCellStyle(style);

            cell = row.createCell(21);
            cell.setCellValue("动作2-频率");
            cell.setCellStyle(style);

            cell = row.createCell(22);
            cell.setCellValue("动作2-旋转");
            cell.setCellStyle(style);

            cell = row.createCell(23);
            cell.setCellValue("动作2-流畅度");
            cell.setCellStyle(style);

            cell = row.createCell(24);
            cell.setCellValue("动作2-力量");
            cell.setCellStyle(style);

            cell = row.createCell(25);
            cell.setCellValue("动作3-速度");
            cell.setCellStyle(style);

            cell = row.createCell(26);
            cell.setCellValue("动作3-频率");
            cell.setCellStyle(style);

            cell = row.createCell(27);
            cell.setCellValue("动作3-旋转");
            cell.setCellStyle(style);

            cell = row.createCell(28);
            cell.setCellValue("动作3-流畅度");
            cell.setCellStyle(style);

            cell = row.createCell(29);
            cell.setCellValue("动作3-力量");
            cell.setCellStyle(style);

            cell = row.createCell(30);
            cell.setCellValue("动作4-速度");
            cell.setCellStyle(style);

            cell = row.createCell(31);
            cell.setCellValue("动作4-频率");
            cell.setCellStyle(style);

            cell = row.createCell(32);
            cell.setCellValue("动作4-旋转");
            cell.setCellStyle(style);

            cell = row.createCell(33);
            cell.setCellValue("动作4-流畅度");
            cell.setCellStyle(style);

            cell = row.createCell(34);
            cell.setCellValue("动作4-力量");
            cell.setCellStyle(style);

        }else if (a == 5){
            cell = row.createCell(0);
            cell.setCellValue("开始时间");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("结束时间");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("参加人数");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("动作1完成率");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("动作2完成率");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("动作3完成率");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("动作4完成率");
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue("整体完成率");
            cell.setCellStyle(style);
        }

    }

    //生成user表excel
    @GetMapping(value = "/getUser")
    public String getUser(HttpServletResponse response) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        createTitle(workbook,sheet,1);
        List<ReturnStudentListDTO> rows = userService.selectStudentList();

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(ReturnStudentListDTO user:rows){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getUc_id());
            row.createCell(1).setCellValue(user.getUc_name());
            row.createCell(2).setCellValue(user.getUc_phone());
            row.createCell(3).setCellValue(user.getEq_mac());
            row.createCell(4).setCellValue(user.getTc_name());
//            HSSFCell cell = row.createCell(3);
//            cell.setCellValue(user.getUc_phone());
//            cell.setCellStyle(style);
            rowNum++;
        }
        String fileName = "学生信息.xls";
        //生成excel文件
        buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
    }

    //生成学生表excel
    @GetMapping(value = "/getTrainUser")
    public String getTrainUser(HttpServletResponse response) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        createTitle(workbook,sheet,2);
        List<ReturnCoachDTO> rows = userService.selectCoachlList();

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(ReturnCoachDTO user:rows){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getU_id());
            row.createCell(1).setCellValue(user.getU_name());
            row.createCell(2).setCellValue(user.getU_phone());
            row.createCell(3).setCellValue(user.getCoach_teaching_age());
            row.createCell(4).setCellValue(user.getCoach_title());
//            HSSFCell cell = row.createCell(3);
//            cell.setCellValue(user.getUc_phone());
//            cell.setCellStyle(style);
            rowNum++;
        }
        String fileName = "教龄信息.xls";
        //生成excel文件
        buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
    }

    //生成班级表excel
    @GetMapping(value = "/getClass")
    public String getClass(HttpServletResponse response) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        createTitle(workbook,sheet,3);
        List<AdminClass> rows = userService.selectClass();

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(AdminClass user:rows){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getTc_id());
            row.createCell(1).setCellValue(user.getTc_name());
            row.createCell(2).setCellValue(user.getTc_number());
            row.createCell(3).setCellValue(user.getU_name());
//            HSSFCell cell = row.createCell(3);
//            cell.setCellValue(user.getUc_phone());
//            cell.setCellStyle(style);
            rowNum++;
        }
        String fileName = "班级信息.xls";
        //生成excel文件
        buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
    }

    //生成班级表excel
    @RequestMapping(value = "/getClassTrainExcel")
    public String getClassTrainExcel(HttpServletResponse response,HttpServletRequest request, Model model) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("班级训练报告");
        createTitle(workbook,sheet,5);
        int tc_id = Integer.parseInt(request.getParameter("id"));
        String start_time = request.getParameter("startTime");
        String end_time = request.getParameter("endTime");
        List<ClassTrainExcelDTO> classTrainExcelDTO = userService.getClassTrainExcel(tc_id,start_time,end_time);

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(ClassTrainExcelDTO user:classTrainExcelDTO){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getStart_time());
            row.createCell(1).setCellValue(user.getEnd_time());
            row.createCell(2).setCellValue(user.getTrain_people_number());
            row.createCell(3).setCellValue(user.getOne_completion_rate());
            row.createCell(4).setCellValue(user.getTwo_completion_rate());
            row.createCell(5).setCellValue(user.getThree_completion_rate());
            row.createCell(6).setCellValue(user.getFour_completion_rate());
            row.createCell(7).setCellValue(user.getTotal_completion_rate());
//            HSSFCell cell = row.createCell(3);
//            cell.setCellValue(user.getUc_phone());
//            cell.setCellStyle(style);
            rowNum++;
        }
        String fileName = "班级训练报告.xls";
        //生成excel文件
        buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
    }

    //生成学生个人训练数据excel
    @RequestMapping(value = "/getStudentTrain")
    public String getStudentTrain(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("个人训练数据");
        createTitle(workbook,sheet,4);
        int uc_id = Integer.parseInt(request.getParameter("id"));
        String start_time = request.getParameter("startTime");
        String end_time = request.getParameter("endTime");
        List<StudentTrainTotalList> studentTrainTotalList = userService.getStudentTrain(uc_id,start_time,end_time);

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(StudentTrainTotalList totalList:studentTrainTotalList){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(totalList.getStart_time());
            row.createCell(1).setCellValue(totalList.getEnd_time());
            row.createCell(2).setCellValue(totalList.getAction_one_rate());
            row.createCell(3).setCellValue(totalList.getAction_two_rate());
            row.createCell(4).setCellValue(totalList.getAction_three_rate());
            row.createCell(5).setCellValue(totalList.getAction_four_rate());
            row.createCell(6).setCellValue(totalList.getAction_total_rate());
            row.createCell(7).setCellValue(totalList.getAction_set_one());
            row.createCell(8).setCellValue(totalList.getAction_set_two());
            row.createCell(9).setCellValue(totalList.getAction_set_three());
            row.createCell(10).setCellValue(totalList.getAction_set_four());
            row.createCell(11).setCellValue(totalList.getAction_actual_one());
            row.createCell(12).setCellValue(totalList.getAction_actual_two());
            row.createCell(13).setCellValue(totalList.getAction_actual_three());
            row.createCell(14).setCellValue(totalList.getAction_actual_four());
            row.createCell(15).setCellValue(totalList.getAction_one_speed());
            row.createCell(16).setCellValue(totalList.getAction_one_frequency());
            row.createCell(17).setCellValue(totalList.getAction_one_melody());
            row.createCell(18).setCellValue(totalList.getAction_one_fluency());
            row.createCell(19).setCellValue(totalList.getAction_one_power());
            row.createCell(20).setCellValue(totalList.getAction_two_speed());
            row.createCell(21).setCellValue(totalList.getAction_two_frequency());
            row.createCell(22).setCellValue(totalList.getAction_two_melody());
            row.createCell(23).setCellValue(totalList.getAction_two_fluency());
            row.createCell(24).setCellValue(totalList.getAction_two_power());
            row.createCell(25).setCellValue(totalList.getAction_three_speed());
            row.createCell(26).setCellValue(totalList.getAction_three_frequency());
            row.createCell(27).setCellValue(totalList.getAction_three_melody());
            row.createCell(28).setCellValue(totalList.getAction_three_fluency());
            row.createCell(29).setCellValue(totalList.getAction_three_power());
            row.createCell(30).setCellValue(totalList.getAction_four_speed());
            row.createCell(31).setCellValue(totalList.getAction_four_frequency());
            row.createCell(32).setCellValue(totalList.getAction_four_melody());
            row.createCell(33).setCellValue(totalList.getAction_four_fluency());
            row.createCell(34).setCellValue(totalList.getAction_four_power());

//            HSSFCell cell = row.createCell(3);
//            cell.setCellValue(user.getUc_phone());
//            cell.setCellStyle(style);
            rowNum++;
        }
        String fileName = "学生个人训练.xls";
        //生成excel文件
        buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);
        return "download excel";
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
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


    @RequestMapping(value = "/downloadAimsAPK")
    public String downloadAimsAPK(HttpServletRequest request,
                                  HttpServletResponse response) throws UnsupportedEncodingException {
        String fileNameApk = request.getParameter("fileName");
        // 获取指定目录下的第一个文件
        File scFileDir = new File("D://IdeaProjects//amisbuild001//picture_apk//apk//"+fileNameApk+".apk");
        String fileName = scFileDir.getName(); //下载的文件名

        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = "D://IdeaProjects//amisbuild001//picture_apk//apk";
            File file = new File(realPath, fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                }
                catch (Exception e) {
                    System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
