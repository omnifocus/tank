package com.shilei.tank;

import com.shilei.tank.collider.BulletTankCollider;
import com.shilei.tank.collider.Collide;
import com.shilei.tank.collider.TankTankCollider;
import com.shilei.util.RandomDir;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {
    Tank tank = new Tank(100,100,Dir.Right,Group.GOOD,this);
    public java.util.List<GameObject> goes = new ArrayList<>();
    Collide bulletTankCollider = new BulletTankCollider();
    Collide tankTankCollider = new TankTankCollider();
    public GameModel() {
        int size = Integer.parseInt((String) PropertyMgr.get("initEnemyCount"));
        for (int i=0;i<size;i++) {
            Tank tank = new Tank(i*60, 100, RandomDir.randomDir(),Group.BAD,this);
            goes.add(tank);
        }
    }

    public void draw(Graphics g) {
        Color originColor = g.getColor();
        g.setColor(Color.black);
        g.fillRect(0,0,TankFrame.frameW,TankFrame.frameH);
//        g.setColor(Color.orange);
//        g.drawString("当前子弹数量：" + bullets.size(),10,50);
//        g.drawString("当前敌方坦克数量：" + enemyTanks.size(),10,70);
//        g.drawString("当前爆炸数量：" + explodes.size(),10,90);
        tank.draw(g);

        for (int i=0;i<goes.size();i++) {
            goes.get(i).draw(g);
        }
        for (int i=0;i<goes.size();i++) {
            for (int j=i+1;j<goes.size();j++) {
                GameObject o1 = goes.get(i);
                GameObject o2 = goes.get(j);
                bulletTankCollider.collide(o1,o2);
                tankTankCollider.collide(o1,o2);
            }
        }




        g.setColor(originColor);
    }

    public void add(GameObject go) {
        this.goes.add(go);
    }

    public void remove(GameObject go) {
        this.goes.remove(go);
    }
}
