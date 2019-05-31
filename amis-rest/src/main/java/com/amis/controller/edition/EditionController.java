package com.amis.controller.edition;

import com.amis.common.ResponseVO;
import com.amis.common.exception.MessageKey;
import com.amis.entity.Edition;
import com.amis.entity.dto.TrainLog;
import com.amis.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName EditionController
 * @Description 版本
 * @Author chenzexin
 * @Date 2019/4/11 15:32
 **/


@RestController
@RequestMapping(value = "edition")
public class EditionController {

    @Autowired
    private EditionService editionService;

    // 本地"D:/IdeaProjects/amisbuild001/picture_apk/"   服务器：D:/AMISJAVA/picture_apk/
    private static String urlC = "D:/AMISJAVA/picture_apk/";
    private static String ipC = "47.52.249.147:3000";

    /**
     * @Author chenzexin
     * @Date 2019/4/16 17:15
     * @param
     * @return com.amis.common.ResponseVO
     * @Description        获取当前最新版本
     **/
    @ResponseBody
    @RequestMapping(value = "getVersion",method = RequestMethod.POST)
    public ResponseVO getEdition(){
        Edition edition = editionService.getEdition();
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(edition);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/11 15:58
     * @param s
     * @return com.amis.common.ResponseVO
     * @Description        版本升级接口
     **/
    @ResponseBody
    @RequestMapping(value = "editionUpgrade",method = RequestMethod.POST)
    public ResponseVO editionUpgrade(MultipartFile file,Edition edition) throws Exception {
        String  pathName= urlC+"apk/";
        // 自定义的文件名称
        String fileName = file.getOriginalFilename();// 文件原名称
        String fileUrl = "http://"+ipC+"/apk/"+fileName;
        String path = photoUpload(file,fileName,pathName);
        edition.setFileUrl(fileUrl);
        editionService.editionUpgrade(edition);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/15 16:29
     * @param file
     * @param userId
     * @return com.amis.common.ResponseVO
     * @Description        修改用户头像
     **/
    @ResponseBody
    @RequestMapping(value = "photoUpload",method = RequestMethod.POST)
    public ResponseVO photoUpload(MultipartFile file, int userId) throws Exception{
        String  pathName= urlC+"headpicture/";
        // 自定义的文件名称
        String fileName = String.valueOf(System.currentTimeMillis())+"_"+userId + file.getOriginalFilename();// 文件原名称
        String fileUrl = "http://"+ipC+"/headpicture/"+fileName;
        String path = photoUpload(file,fileName,pathName);
        editionService.photoUpload(fileUrl,userId);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(fileUrl);
        responseVO.setId(userId);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/4/16 10:48
     * @param file
     * @return com.amis.common.ResponseVO
     * @Description        上传模型
     **/
    @ResponseBody
    @RequestMapping(value = "modelUpload",method = RequestMethod.POST)
    public ResponseVO modelUpload(MultipartFile file) throws Exception{
        int a = editionService.selectModelCount();
        String  pathName= urlC+"models/model_"+ a +"/";
        // 自定义的文件名称 String.valueOf(System.currentTimeMillis()) +
        String fileName = file.getOriginalFilename();// 文件原名称
        String fileUrl = "http://"+ipC+"/models/model_"+ a +"/"+fileName;
        String path = photoUpload(file,fileName,pathName);
        editionService.modelUpload(fileUrl);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(fileUrl);
        return responseVO;
    }



    /**
     * @Author chenzexin
     * @Date 2019/4/22 15:34
     * @param file
     * @return com.amis.common.ResponseVO
     * @Description        上传用户个人模型
     **/
    @ResponseBody
    @RequestMapping(value = "trainLogUpload",method = RequestMethod.POST)
    public ResponseVO trainLogUpload(MultipartFile file, TrainLog trainLog) throws Exception{
        String  pathName= urlC+"trainLog/";
        // 自定义的文件名称 String.valueOf(System.currentTimeMillis()) +
        String fileName = file.getOriginalFilename();// 文件原名称
        String fileUrl = "http://"+ipC+"/trainLog/"+fileName;
        String path = photoUpload(file,fileName,pathName);
        trainLog.setFileUrl(fileUrl);
        editionService.trainLogUpload(trainLog);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(fileUrl);
        return responseVO;
    }

    /**
     * @Author chenzexin
     * @Date 2019/5/31 11:29
     * @param file
     * @param trainLog
     * @return com.amis.common.ResponseVO
     * @Description        上传错误日志txt
     **/
    @ResponseBody
    @RequestMapping(value = "trainLogError",method = RequestMethod.POST)
    public ResponseVO trainLogError(MultipartFile file, TrainLog trainLog) throws Exception{
        String  pathName= urlC+"trainLog/";
        // 自定义的文件名称 String.valueOf(System.currentTimeMillis()) +
        String fileName = file.getOriginalFilename();// 文件原名称
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        String fileUrl = "http://"+ipC+"/trainLog/"+trainLog.getInsertTime()+fileName;
        String path = photoUpload(file,fileName,pathName);
        trainLog.setFileUrl(fileUrl);
        editionService.trainLogUpload(trainLog);
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        responseVO.setData(fileUrl);
        return responseVO;
    }


    public static String photoUpload(MultipartFile file,String fileName,String realPath) throws Exception {
        String path = null;
        if (file != null) {// 判断上传的文件是否为空
            // 文件路径
            String type = null;// 文件类型
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
                    : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
                        || "JPG".equals(type.toUpperCase()) || "TXT".equals(type.toUpperCase())
                        || "MODEL".equals(type.toUpperCase()) ||"ZIP".equals(type.toUpperCase())
                        || "APK".equals(type.toUpperCase())) {
                    path = realPath + /* System.getProperty("file.separator")+ */fileName;
                    File filepath = new File(path);
                    System.out.println(filepath.getParentFile());
                    if (!filepath.getParentFile().exists()) {
                        boolean result = filepath.getParentFile().mkdirs();
                        if (!result) {
                            System.out.println("创建失败");
                        }
                    }
                    System.out.println("存放图片文件的路径:" + path);
                    // 转存文件到指定的路径
                    file.transferTo(filepath);
                    System.out.println("文件成功上传到指定目录下");
                } else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return null;
                }
            } else {
                System.out.println("文件类型为空");
                return null;
            }
        } else {
            System.out.println("没有找到相对应的文件");
            return null;
        }
        return path;
    }

}





