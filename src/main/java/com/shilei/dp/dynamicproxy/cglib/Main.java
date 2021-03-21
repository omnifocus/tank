package com.shilei.dp.dynamicproxy.cglib;

import com.shilei.dp.dynamicproxy.Tank;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new LogProxy());
        Tank proxy = (Tank) enhancer.create();
        proxy.move();
    }
}
class LogProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin>>");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("end<<");
        return result;
    }
}