package com.git.zxxxd.controller;

import com.git.zxxxd.configuration.DynamicSchedule;
import com.git.zxxxd.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;
    @Autowired
    DynamicSchedule dynamicSchedule;

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "success";
    }
    @GetMapping("/test")
    public String test(){
        //任务执行线程
        try {
            Runnable runnable = new ScheduledMethodRunnable(this.dynamicSchedule, "hello");
//            //注册任务
//            dynamicSchedule.registrar.scheduleCronTask(
//                    new CronTask(runnable, new CronTrigger("0/2 * * * * *", TimeZone.getDefault())));
            dynamicSchedule.addTriggerTask("1",new CronTask(runnable, new CronTrigger("0/2 * * * * *", TimeZone.getDefault())));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "success";
    }
    @GetMapping("/stop")
    public String stop(){
        //任务执行线程
        try {
            dynamicSchedule.cancelTriggerTask("1");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
