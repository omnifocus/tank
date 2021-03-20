package com.shilei.tank;

import com.shilei.tank.dp.abstractfactory2.BaseExplode;
import com.shilei.util.Audio;

import java.awt.*;

public class RectExplode extends BaseExplode {
    private int x, y;
    public static int explodeW = ResourceMgr.explodes[0].getWidth();
    public static int explodeH = ResourceMgr.explodes[0].getHeight();
    private GameModel gm;
    private int step = 0;

    public RectExplode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void draw(Graphics g) {
        if (step++ <= 15) {
            Color c = g.getColor();
            g.setColor(Color.red);
            g.fillRect(x, y, explodeW + step * 10, explodeH + step * 10);
            g.setColor(c);
        } else {
            gm.explodes.remove(this);
        }
    }


}
