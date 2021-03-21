package com.shilei.tank.collider;

import com.shilei.tank.Bullet;
import com.shilei.tank.GameObject;
import com.shilei.tank.Tank;
import com.shilei.tank.dp.cor.FilterChain;

public class BulletTankCollider implements Collide{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            //撞上就返回false,否则true
            return !b.collide(t);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2,o1);
        }
        //没撞上返回true
        return true;
    }


}
