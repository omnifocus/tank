package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.Dir;
import com.shilei.tank.Group;
import com.shilei.tank.RectExplode;
import com.shilei.tank.TankFrame;

public class RectFactory extends AbstractFactory{
    private static RectFactory rectFactory = new RectFactory();
    private RectFactory() {}
    public static RectFactory getInstance() {
        return rectFactory;
    }
    @Override
    public BaseTank genTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet genBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode genExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }
}
