package com.test.zxd;


import com.git.zxd.PluginBase;
import com.git.zxd.PluginEvent;

/**
 * Created by zhangxuedong on 2017/2/23.
 */
public class TestPluginClient extends PluginBase {
    private  String s="实力化成功！";
    public void init(Object o){

    }

    @Override
    public void plugin(PluginEvent pluginEvent) {
        System.out.println("jar内部打印数据"+pluginEvent.getEventId());
        pluginEvent.setAppendDescription("jar内部处理返回数据");
    }

    @Override
    public int getSort() {
        return 0;
    }
}
