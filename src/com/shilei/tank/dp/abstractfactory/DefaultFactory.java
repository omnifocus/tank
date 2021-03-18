package com.shilei.tank.dp.abstractfactory;

public class DefaultFactory extends AbstractFactory{
    private static DefaultFactory img = new DefaultFactory();
    private DefaultFactory() {}
    public static DefaultFactory getInstance() {
        return img;
    }

    @Override
    public AbstractImage createTankImg() {
        return DefaultTankImage.getInstance();
    }

    @Override
    public AbstractImage createBulletImg() {
        return DefaultBulletImg.getInstance();
    }

    @Override
    public AbstractExplode createExplodeImg() {
        return DefaultExplode.getInstance();
    }
}
