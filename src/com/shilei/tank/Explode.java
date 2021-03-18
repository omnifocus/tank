package com.shilei.tank;

import com.shilei.tank.dp.abstractfactory.AbstractFactory;
import com.shilei.util.Audio;

import java.awt.*;
import java.lang.reflect.Method;

public class Explode {
    private int x,y;
    public static  int explodeW;
    public static  int explodeH;
    private TankFrame tf;
    private int step = 0;
    static AbstractFactory abstractFactory;
    static {
        try {
            Class clazz3 = Class.forName(PropertyMgr.get("factory"));
            Method method3 = clazz3.getMethod("getInstance");
            abstractFactory = (AbstractFactory) method3.invoke(clazz3);
            explodeW = abstractFactory.createExplodeImg().explodes()[0].getWidth();
            explodeH = abstractFactory.createExplodeImg().explodes()[0].getHeight();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    public void draw(Graphics g) {
        if (step <= 15) {
            g.drawImage(abstractFactory.createExplodeImg().explodes()[step++], x,y,null);
        } else {
            tf.explodes.remove(this);
        }
    }


}
