package com.shilei.tank.dp.factory.simplefactory.ext;

import com.shilei.tank.dp.factory.simplefactory.Moveable;
import com.shilei.tank.dp.factory.simplefactory.Train;

public class TrainFactory extends AbstractFactory{
    @Override
    Moveable create() {
        return new Train();
    }
}
