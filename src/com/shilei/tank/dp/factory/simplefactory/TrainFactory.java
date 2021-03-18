package com.shilei.tank.dp.factory.simplefactory;

public class TrainFactory {
    static Moveable create() {
        return new Train();
    }
}
