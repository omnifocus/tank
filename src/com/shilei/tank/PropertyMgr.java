package com.shilei.tank;

import jdk.nashorn.internal.runtime.Property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyMgr {
    static Properties props ;

    static  {
        props = new Properties() ;
        final InputStream is = PropertyMgr.class.getClassLoader().getResourceAsStream("conf/config");
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static Object get(String key) {
        return props.get(key);
    }
}
