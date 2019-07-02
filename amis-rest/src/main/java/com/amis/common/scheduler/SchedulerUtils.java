package com.amis.common.scheduler;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.amis.common.db.DbBackups;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName SchedulerUtils
 * @Description 定时器
 * @Author chenzexin
 * @Date 2019/5/27 11:35
 **/
@Component
public class SchedulerUtils {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    //每天3：05执行
    @Scheduled(cron = "0 00 00 ? * *")
    public void testTasksDate() {
        System.err.println("定时任务执行时间：" + dateFormat.format(new Date()));
        try {
            if (DbBackups.exportDatabaseTool()) {
                System.out.println("数据库成功备份！！！");
            } else {
                System.out.println("数据库备份失败！！！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
