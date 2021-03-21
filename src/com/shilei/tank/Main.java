package com.shilei.tank;

import com.shilei.util.RandomDir;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       TankFrame tf = new TankFrame();
        int size = Integer.parseInt((String) PropertyMgr.get("initEnemyCount"));
        for (int i=0;i<size;i++) {
            Tank tank = new Tank(i*60+80, 100, RandomDir.randomDir(),tf);
            tf.enemyTanks.add(tank);
        }

       while (true) {
           Thread.sleep(100);
           tf.repaint();
       }
    }
}
