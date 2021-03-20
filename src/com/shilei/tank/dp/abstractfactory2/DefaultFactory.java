package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.*;

public  class DefaultFactory extends AbstractFactory{
    private static DefaultFactory factory = new DefaultFactory();
    private DefaultFactory() {}
    public static DefaultFactory getInstance() {
        return factory;
    }

    @Override
    public BaseTank genTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Tank(x,y,dir,group,gm);
    }

    @Override
    public BaseBullet genBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Bullet(x,y,dir,group,gm);
    }

    @Override
    public BaseExplode genExplode(int x, int y, GameModel gm) {
        return new Explode(x,y,gm);
    }
}
