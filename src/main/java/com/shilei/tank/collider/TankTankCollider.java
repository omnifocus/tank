package com.shilei.tank.collider;

import com.shilei.tank.GameObject;
import com.shilei.tank.Tank;
import com.shilei.tank.dp.cor.FilterChain;

import java.util.logging.Filter;

public class TankTankCollider implements Collide{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            t1.collideWith(t2);
        }
        return true;
    }
}