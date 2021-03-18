package com.shilei.tank.dp.factory.simplefactory;

public class CarFactory {
    static Moveable create() {
        return new Car();
    }
}
