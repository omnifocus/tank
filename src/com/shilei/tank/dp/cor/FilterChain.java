package com.shilei.tank.dp.cor;

import com.shilei.tank.GameObject;
import com.shilei.tank.collider.Collide;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Collide> collideList = new ArrayList<>();
    private int step;
    public FilterChain addCollider(Collide collide) {
        collideList.add(collide);
        return this;
    }

    public void doFilter(GameObject o1,GameObject o2) {
        if (step < collideList.size()) {
            collideList.get(step++).collide(o1,o2,this);
        } else {
            step = 0;
        }
    }
}
