package com.shilei.dp.proxy;

import java.util.Random;

public class Tank implements Moveable{
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("claclacla, tank moving....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
