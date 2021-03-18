package com.shilei.tank;

import com.shilei.tank.dp.abstractfactory2.BaseExplode;
import com.shilei.util.Audio;

import java.awt.*;

public class RectExplode extends BaseExplode {
    private int x, y;
    public static int explodeW = ResourceMgr.explodes[0].getWidth();
    public static int explodeH = ResourceMgr.explodes[0].getHeight();
    private TankFrame tf;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void draw(Graphics g) {
        if (step++ <= 15) {
            Color c = g.getColor();
            g.setColor(Color.red);
            g.fillRect(x, y, explodeW + step * 10, explodeH + step * 10);
            g.setColor(c);
        } else {
            tf.explodes.remove(this);
        }
    }


}
