package com.shilei.tank;

import com.shilei.tank.dp.abstractfactory2.BaseExplode;
import com.shilei.util.Audio;

import java.awt.*;

public class Explode extends BaseExplode {
    private int x,y;
    public static final int BULLETW = ResourceMgr.explodes[0].getWidth();
    public static final int BULLETH = ResourceMgr.explodes[0].getHeight();
    public GameModel gm;
    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    public void draw(Graphics g) {
        if (step <= 15) {
            g.drawImage(ResourceMgr.explodes[step++], x,y,null);
        } else {
            gm.explodes.remove(this);
        }
    }


}
