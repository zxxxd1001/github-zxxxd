package demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)  //fixedRate属性每隔固定时间执行
    public void reportCurrentTime() {
        System.out.println("每隔2秒执行一次" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/2 * * * * ?")  //cron属性可按照指定时间执行，这里指每天11点28分执行，cron是Linux系统的定时任务
    public void fixTimeExecution() {
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }
}