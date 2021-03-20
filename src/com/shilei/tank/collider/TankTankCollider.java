package com.shilei.tank.collider;

import com.shilei.tank.GameObject;
import com.shilei.tank.Tank;

public class TankTankCollider implements Collide{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            t1.collideWith(t2);
        }
    }
}
