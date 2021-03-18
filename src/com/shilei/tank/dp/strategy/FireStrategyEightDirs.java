package com.shilei.tank.dp.strategy;

import com.shilei.tank.*;
import com.shilei.util.Audio;

public class FireStrategyEightDirs implements FireStrategy{

    private static FireStrategyEightDirs eightDirs = new FireStrategyEightDirs();
    private FireStrategyEightDirs(){}
    public static FireStrategyEightDirs getInstance() {
        return eightDirs;
    }
    @Override
    public void fireWithTank(Tank tank) {
        int bX = tank.x + Tank.TankW / 2 - Bullet.BULLETW / 2;
        int bY = tank.y + Tank.TankH / 2 - Bullet.BULLETH / 2;
        for (Dir dir : Dir.values()) {
            TankFrame.abstractFactory.genBullet(bX,bY,dir,tank.group,tank.tankFrame);
        }
        if (tank.group == Group.BAD)
            return;
        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
