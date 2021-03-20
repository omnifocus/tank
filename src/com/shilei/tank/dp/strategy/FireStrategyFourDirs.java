package com.shilei.tank.dp.strategy;

import com.shilei.tank.Bullet;
import com.shilei.tank.Dir;
import com.shilei.tank.Group;
import com.shilei.tank.Tank;
import com.shilei.tank.dp.abstractfactory2.BaseTank;
import com.shilei.util.Audio;

public class FireStrategyFourDirs implements FireStrategy{
    private static FireStrategyFourDirs fourDirs = new FireStrategyFourDirs();
    private FireStrategyFourDirs(){}
    public static FireStrategyFourDirs getInstance() {
        return fourDirs;
    }
    @Override
    public void fireWithTank(BaseTank tank) {
        int bX = tank.x + Tank.TankW / 2 - Bullet.BULLETW / 2;
        int bY = tank.y + Tank.TankH / 2 - Bullet.BULLETH / 2;

        new Bullet(bX, bY, Dir.Up, tank.group, tank.gm);
        new Bullet(bX, bY, Dir.Down, tank.group, tank.gm);
        new Bullet(bX, bY, Dir.Left, tank.group, tank.gm);
        new Bullet(bX, bY, Dir.Right, tank.group, tank.gm);
        if (tank.group == Group.BAD)
            return;
        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }


}
