package com.shilei.dp.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        Moveable moveable = (Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class<?>[]{Moveable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy instanceof Moveable);
                Object obj = null;
                System.out.println("开始执行...");
                if (method.getName().equals("move")) {
                  obj = method.invoke(tank,args);
                }
                System.out.println("执行结束...");
                return obj;
            }
        });
        moveable.move();
    }
}
