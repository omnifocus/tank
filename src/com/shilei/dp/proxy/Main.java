package com.shilei.dp.proxy;

public class Main {
    public static void main(String[] args) {
//        Moveable moveable = new LogProxy(new TimeProxy(new Tank()));
        Moveable moveable = new TimeProxy(new LogProxy(new Tank()));
        moveable.move();
    }
}
