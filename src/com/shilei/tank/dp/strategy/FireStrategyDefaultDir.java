package com.shilei.tank.dp.strategy;

import com.shilei.tank.*;
import com.shilei.tank.dp.decorator.BulletDecorator;
import com.shilei.tank.dp.decorator.TailDecorator;
import com.shilei.util.Audio;

public class FireStrategyDefaultDir implements FireStrategy{

    private static FireStrategyDefaultDir defaultDir = new FireStrategyDefaultDir();
    private FireStrategyDefaultDir(){}
    public static FireStrategyDefaultDir getInstance() {
        return defaultDir;
    }
    @Override
    public void fireWithTank(Tank tank) {
        int bX = tank.x + Tank.TankW / 2 - Bullet.BULLETW / 2;
        int bY = tank.y + Tank.TankH / 2 - Bullet.BULLETH / 2;
        GameModel.getInstance().add( new TailDecorator(new BulletDecorator(new Bullet(bX,bY,tank.dir,tank.group))));
        if (tank.group == Group.BAD)
            return;
        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
