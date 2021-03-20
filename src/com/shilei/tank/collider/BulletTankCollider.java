package com.shilei.tank.collider;

import com.shilei.tank.Bullet;
import com.shilei.tank.GameObject;
import com.shilei.tank.Tank;
import com.shilei.tank.dp.cor.FilterChain;

public class BulletTankCollider implements Collide{
    @Override
    public void collide(GameObject o1, GameObject o2, FilterChain chain) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            b.collide(t);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2,o1,chain);
        }
        chain.doFilter(o1,o2);
    }


}
