package com.amis.common.scheduler;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.amis.common.db.DbBackups;
import com.amis.service.ReceiveDataService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private ReceiveDataService receiveDataService;


    //每天凌晨备份数据库
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


    /**
     * @Author chenzexin
     * @Date 2019/8/13 9:46
     * @param
     * @return void
     * @Description        每天凌晨0点创建新表
     **/
    @Scheduled(cron = "0 00 00 ? * *")
    public void newBuildTab() {
        //获取当前日期，并创建新的数据库表
            SimpleDateFormat dates = new SimpleDateFormat("yyyy_MM_dd");
            String formats = dates.format(new Date(System.currentTimeMillis()));
            receiveDataService.newBuildTab(formats+"motionData");
    }


}
