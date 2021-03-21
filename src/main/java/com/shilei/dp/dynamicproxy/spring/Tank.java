package com.shilei.dp.dynamicproxy.spring;

import com.shilei.dp.dynamicproxy.Moveable;

import java.util.Random;

public class Tank implements Moveable {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("claclacla...tank moving");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
