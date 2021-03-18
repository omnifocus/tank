package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.*;

public  class DefaultFactory extends AbstractFactory{


    @Override
    public BaseTank genTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet genBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode genExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }
}
