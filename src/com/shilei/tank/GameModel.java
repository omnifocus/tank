package com.shilei.tank;

import com.shilei.util.RandomDir;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {
    Tank tank = new Tank(100,100,Dir.Right,Group.GOOD,this);
    public java.util.List<Bullet> bullets = new ArrayList<>();
    public java.util.List<Tank> enemyTanks = new ArrayList<>();
    public java.util.List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int size = Integer.parseInt((String) PropertyMgr.get("initEnemyCount"));
        for (int i=0;i<size;i++) {
            Tank tank = new Tank(i*60, 100, RandomDir.randomDir(),Group.BAD,this);
            enemyTanks.add(tank);
        }
    }

    public void draw(Graphics g) {
        Color originColor = g.getColor();
        g.setColor(Color.black);
        g.fillRect(0,0,TankFrame.frameW,TankFrame.frameH);
        g.setColor(Color.orange);
        g.drawString("当前子弹数量：" + bullets.size(),10,50);
        g.drawString("当前敌方坦克数量：" + enemyTanks.size(),10,70);
        g.drawString("当前爆炸数量：" + explodes.size(),10,90);
        tank.draw(g);
        for (int i=0;i<enemyTanks.size();i++) {
            enemyTanks.get(i).draw(g);
        }

        for (int i=0;i<bullets.size();i++) {
            for (int j=0;j<enemyTanks.size();j++) {
                bullets.get(i).collide(enemyTanks.get(j));
            }
        }

        for (int i=0;i<bullets.size();i++)
            bullets.get(i).draw(g);

        for (int i=0;i<explodes.size();i++) {
            explodes.get(i).draw(g);
        }

        g.setColor(originColor);
    }
}
