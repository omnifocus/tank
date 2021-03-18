package com.shilei.tank.dp.factory.simplefactory;

public class Main {
    public static void main(String[] args) {
        Moveable moveable1 = new Car();
        Moveable moveable2 = new Train();
        Moveable moveable3 = CarFactory.create();
        Moveable moveable4 = TrainFactory.create();
    }
}
