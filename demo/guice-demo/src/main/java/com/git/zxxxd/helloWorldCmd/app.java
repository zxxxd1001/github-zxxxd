package com.git.zxxxd.helloWorldCmd;

import com.google.common.base.Joiner;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Modules;

import java.util.Map;

/**
 * 去除依赖 dependency
 */
public class app {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(Modules.override(new MainModule()).with(new CommandModule(args)));
        Applet.getApplate(injector,args[1]).run();
    }
}
