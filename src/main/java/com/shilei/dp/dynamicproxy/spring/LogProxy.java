package com.shilei.dp.dynamicproxy.spring;

public class LogProxy {
    public void logBefore() {
        System.out.println("LogProxy.logBefore");
    }

    public void logAfter() {
        System.out.println("LogProxy.logAfter");
    }
}
