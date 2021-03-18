package com.shilei.tank;

import com.shilei.tank.dp.abstractfactory.AbstractFactory;
import com.shilei.tank.dp.abstractfactory2.BaseExplode;
import com.shilei.util.Audio;

import java.awt.*;
import java.lang.reflect.Method;

public class Explode extends BaseExplode {
    private int x,y;
    public static  int explodeW;
    public static  int explodeH;
    private TankFrame tf;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    public void draw(Graphics g) {
        if (step <= 15) {
            g.drawImage(ResourceMgr.explodes[step++], x,y,null);
        } else {
            tf.explodes.remove(this);
        }
    }


}
