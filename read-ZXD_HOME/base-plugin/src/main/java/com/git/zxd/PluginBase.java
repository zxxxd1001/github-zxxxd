package com.git.zxd;

/**
 * Created by zhangxuedong on 2017/2/23.
 */
public abstract class PluginBase {
    public abstract int getSort();

    public abstract void plugin(PluginEvent e);

    public void init(Object o){}
}
