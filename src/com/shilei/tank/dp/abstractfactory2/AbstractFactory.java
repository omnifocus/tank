package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.Dir;
import com.shilei.tank.Group;
import com.shilei.tank.TankFrame;

public abstract class AbstractFactory {
    public abstract BaseTank genTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseBullet genBullet(int x, int y, Dir dir, Group group,TankFrame tf);

    public abstract BaseExplode genExplode(int x, int y,TankFrame tf);
}
