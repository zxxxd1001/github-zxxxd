package com.company.eventDelegateModel;

import java.util.Date;

/**
 * Created by zhangxuedong on 2017/2/20.
 */
public class WatchingTVListener {
    public WatchingTVListener(){
        System.out.println("我正在看电视 "+new Date());
    }
    public void stopWatchingTV(Date date){
        System.out.println("老师来了，快关闭电视 。 结束时间"+date);
    }
}
