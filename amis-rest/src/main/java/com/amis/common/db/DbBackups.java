package com.amis.common.db;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DbBackups
 * @Description 数据库备份
 * @Author chenzexin
 * @Date 2019/5/27 10:15
 **/
public class DbBackups {
    /**
     * Java代码实现MySQL数据库导出
     *
     * @author ChenZeXin
     * @param hostIP MySQL数据库所在服务器地址IP
     * @param userName 进入数据库所需要的用户名
     * @param password 进入数据库所需要的密码
     * @param savePath 数据库导出文件保存路径
     * @param fileName 数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @return 返回true表示导出成功，否则返回false。
     */
    public static boolean exportDatabaseTool() throws InterruptedException {
        String filePath="D:\\backupDatabase\\";
        /*String fileName="批量上传模板.xlsx";*/
        String dbName="amis";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        try {
            Process process = Runtime.getRuntime().exec(
                    "cmd  /c  mysqldump -u amis -pamis123 " + dbName + " > "
                            + filePath + "/" + dbName+date
                            + ".sql");
            //备份的数据库名字为teacher，数据库连接和密码均为root
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

}
