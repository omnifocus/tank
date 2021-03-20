package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.*;

public class RectFactory extends AbstractFactory{
    private static RectFactory rectFactory = new RectFactory();
    private RectFactory() {}
    public static RectFactory getInstance() {
        return rectFactory;
    }
    @Override
    public BaseTank genTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new RectTank(x,y,dir,group,gm);
    }

    @Override
    public BaseBullet genBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return new RectBullet(x,y,dir,group,gm);
    }

    @Override
    public BaseExplode genExplode(int x, int y, GameModel gm) {
        return new RectExplode(x,y,gm);
    }
}
