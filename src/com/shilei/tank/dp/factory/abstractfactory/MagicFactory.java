package com.shilei.tank.dp.factory.abstractfactory;

public class MagicFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Mushroom();
    }

    @Override
    Gun createWeapon() {
        return new MagicStick();
    }
}
