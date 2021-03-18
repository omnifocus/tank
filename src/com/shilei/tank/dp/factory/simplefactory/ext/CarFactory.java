package com.shilei.tank.dp.factory.simplefactory.ext;

import com.shilei.tank.dp.factory.simplefactory.Car;
import com.shilei.tank.dp.factory.simplefactory.Moveable;

public class CarFactory extends AbstractFactory{
    @Override
    Moveable create() {
        return new Car();
    }
}
