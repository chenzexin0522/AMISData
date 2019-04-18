package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Edition
 * @Description 版本实体类
 * @Author chenzexin
 * @Date 2019/4/16 16:48
 **/
@Data
public class Edition {
    private int tet_id;             //版本id
    private String versionCode;     //版本号
    private int isUpdate;           //是否需要更新
    private String message;         //更新说明
    private String fileUrl;         //版本地址
    private int isHotUpdate;        //是否需要热更新
    private String hotCode;            //热更新版本号
    private String editionReleasePeople; //项目负责人
}
