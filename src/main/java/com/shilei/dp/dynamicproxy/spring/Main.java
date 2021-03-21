package com.shilei.dp.dynamicproxy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Tank tank = (Tank) ac.getBean("tank");
        tank.move();
    }

}
