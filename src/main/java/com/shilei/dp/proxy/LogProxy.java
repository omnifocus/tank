package com.shilei.dp.proxy;

public class LogProxy implements Moveable{
    private Moveable moveable;

    public LogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("begin log...");
        moveable.move();
        System.out.println("end log ...");
    }
}
