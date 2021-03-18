package com.shilei.tank.dp.abstractfactory;

public class NewSuiteFactory extends AbstractFactory{
    private static NewSuiteFactory img = new NewSuiteFactory();
    private NewSuiteFactory() {}
    public static NewSuiteFactory getInstance() {
        return img;
    }

    @Override
    public AbstractImage createTankImg() {
        return NewSuiteTankImg.getInstance();
    }

    @Override
    public AbstractImage createBulletImg() {
        return NewSuiteBulletImg.getInstance();
    }

    @Override
    public AbstractExplode createExplodeImg() {
        return NewSuiteExplode.getInstance();
    }
}
