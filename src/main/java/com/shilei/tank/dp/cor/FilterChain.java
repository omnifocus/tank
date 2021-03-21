package com.shilei.tank.dp.cor;

import com.shilei.tank.GameObject;
import com.shilei.tank.collider.Collide;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Collide {
    private List<Collide> collideList = new ArrayList<>();
    public FilterChain addCollider(Collide collide) {
        collideList.add(collide);
        return this;
    }
    @Override
    public boolean collide(GameObject o1,GameObject o2) {
      for (Collide collide:collideList) {
          if (!collide.collide(o1,o2))
              return false;
      }
      return true;
    }
}
