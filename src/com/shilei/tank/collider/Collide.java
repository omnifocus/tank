package com.shilei.tank.collider;

import com.shilei.tank.GameObject;
import com.shilei.tank.dp.cor.FilterChain;

public interface Collide {
    void collide(GameObject o1, GameObject o2, FilterChain colliderChain);
}
