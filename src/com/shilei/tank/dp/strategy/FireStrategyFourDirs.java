package com.shilei.tank.dp.strategy;

import com.shilei.tank.Bullet;
import com.shilei.tank.Dir;
import com.shilei.tank.Group;
import com.shilei.tank.Tank;
import com.shilei.util.Audio;

public class FireStrategyFourDirs implements FireStrategy{

    @Override
    public void fireWithTank(Tank tank) {
        int bX = tank.x + Tank.TankW / 2 - Bullet.BULLETW / 2;
        int bY = tank.y + Tank.TankH / 2 - Bullet.BULLETH / 2;
        Bullet b1 = new Bullet(bX, bY, Dir.Up, Group.GOOD, tank.tankFrame);
        Bullet b2 = new Bullet(bX, bY, Dir.Down, Group.GOOD, tank.tankFrame);
        Bullet b3 = new Bullet(bX, bY, Dir.Left, Group.GOOD, tank.tankFrame);
        Bullet b4 = new Bullet(bX, bY, Dir.Right, Group.GOOD, tank.tankFrame);
        tank.tankFrame.bullets.add(b1);
        tank.tankFrame.bullets.add(b2);
        tank.tankFrame.bullets.add(b3);
        tank.tankFrame.bullets.add(b4);
        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
