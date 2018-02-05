package com.git.zxxxd.helloWorldCmd;

import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;

public class Applet {
    public static class AppletRegister{
        private Binder binder;
        private Class<? super MyApplet> clazz;
        private AppletRegister(Binder binder,Class<? super MyApplet> clazz) {
            this.binder=binder;
            this.clazz=clazz;
        }

        public LinkedBindingBuilder<? super MyApplet> named(String print) {
            return MapBinder.newMapBinder(binder,String.class,clazz)
                    .addBinding(print);
        }
    }
    public static AppletRegister register(Binder binder,Class<? super MyApplet> clazz) {
        return  new AppletRegister(binder,clazz);
    }
    public static  MyApplet getApplate(Injector injector, String name){
        Map<String,MyApplet> appletMap = injector.getInstance(Key.get(new TypeLiteral<Map<String,MyApplet>>(){}));
        if(name==null||!appletMap.containsKey(name)){
           throw new IllegalArgumentException("Unable to find applet Valid applet are:"+ Joiner.on(",").join(appletMap.keySet()));
        }
        return appletMap.get(name);
    }
}
