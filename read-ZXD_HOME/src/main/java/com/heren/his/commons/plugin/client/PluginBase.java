package com.heren.his.commons.plugin.client;

/**
 * Created by zhangxuedong on 2017/2/21.
 */
public abstract class PluginBase {

    public abstract int getSort();

    public abstract void plugin(PluginEvent e);

    public void init(Object o){}
}
