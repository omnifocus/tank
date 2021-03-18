package com.shilei.tank.dp.abstractfactory;

public abstract class AbstractFactory {
    public abstract AbstractImage createTankImg();
    public abstract AbstractImage createBulletImg();
    public abstract com.shilei.tank.dp.abstractfactory.AbstractExplode createExplodeImg();
}