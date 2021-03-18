package com.shilei.tank.dp.factory.simplefactory.ext;

import com.shilei.tank.dp.factory.simplefactory.Moveable;

public class Main {
    public static void main(String[] args) {
//        AbstractFactory factory = new CarFactory();
        AbstractFactory factory = new TrainFactory();
        Moveable moveable = factory.create();
        moveable.move();
    }
}
