package com.shilei.tank;

import com.shilei.util.Audio;

import java.awt.*;

public class Explode {
    private int x,y;
    public static final int BULLETW = ResourceMgr.explodes[0].getWidth();
    public static final int BULLETH = ResourceMgr.explodes[0].getHeight();
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
