package com.shilei.dp.proxy;

public class TimeProxy implements Moveable{
    private Moveable moveable;

    public TimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("timeproxy begin...");
        long begin = System.currentTimeMillis();
        moveable.move();
        long end = System.currentTimeMillis();
        System.out.println("timeproxy end .." + (end-begin));
    }
}
