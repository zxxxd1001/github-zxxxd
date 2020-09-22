package com.git.zxxxd.configuration;

import com.git.zxxxd.service.ScheduledService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.SchedulingException;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.ScheduledMethodRunnable;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Configuration
public class DynamicSchedule implements SchedulingConfigurer {

    private Set<ScheduledFuture<?>> scheduledFutures = null;
    private Map<String, ScheduledFuture<?>> taskFutures = new ConcurrentHashMap<>();
    public ScheduledTaskRegistrar registrar;

    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        registrar=scheduledTaskRegistrar;
    }
    private Set<ScheduledFuture<?>> getScheduledFutures() {
        if (scheduledFutures == null) {
            try {
                // spring版本不同选用不同字段scheduledFutures
                scheduledFutures = (Set<ScheduledFuture<?>>) BeanUtils.getProperty(registrar, "scheduledTasks");
            } catch (NoSuchFieldException e) {
                throw new SchedulingException("not found scheduledFutures field.");
            }
        }
        return scheduledFutures;
    }

    /**
     * 添加任务
     */
    public void addTriggerTask(String taskId, TriggerTask triggerTask) {
        if (taskFutures.containsKey(taskId)) {
            throw new SchedulingException("the taskId[" + taskId + "] was added.");
        }
        TaskScheduler scheduler = registrar.getScheduler();
        ScheduledFuture<?> future = scheduler.schedule(triggerTask.getRunnable(), triggerTask.getTrigger());
        getScheduledFutures().add(future);
        taskFutures.put(taskId, future);
    }

    /**
     * 取消任务
     */
    public void cancelTriggerTask(String taskId) {
        ScheduledFuture<?> future = taskFutures.get(taskId);
        if (future != null) {
            future.cancel(true);
        }
        taskFutures.remove(taskId);
        getScheduledFutures().remove(future);
    }

    /**
     * 重置任务
     */
    public void resetTriggerTask(String taskId, TriggerTask triggerTask) {
        cancelTriggerTask(taskId);
        addTriggerTask(taskId, triggerTask);
    }

    /**
     * 任务编号
     */
    public Set<String> taskIds() {
        return taskFutures.keySet();
    }

    /**
     * 是否存在任务
     */
    public boolean hasTask(String taskId) {
        return this.taskFutures.containsKey(taskId);
    }

    /**
     * 任务调度是否已经初始化完成
     */
    public boolean inited() {
        return this.registrar != null && this.registrar.getScheduler() != null;
    }

    public void hello() {
        System.out.println(new Date().getTime());
        System.out.println("DynamicSchedule hello ... ");
    }
}
