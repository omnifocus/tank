package com.shilei.tank.dp.factory.abstractfactory;

public class ModernFactory extends AbstractFactory{

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Gun createWeapon() {
        return new AK47();
    }
}
