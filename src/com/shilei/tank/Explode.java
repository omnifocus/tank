package com.shilei.tank;

import com.shilei.util.Audio;

import java.awt.*;

public class Explode extends GameObject {
    public static final int EXPLODEW = ResourceMgr.explodes[0].getWidth();
    public static final int EXPLODEH = ResourceMgr.explodes[0].getHeight();
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        GameModel.getInstance().add(this);
        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    public void draw(Graphics g) {
        if (step <= 15) {
            g.drawImage(ResourceMgr.explodes[step++], x,y,null);
        } else {
            GameModel.getInstance().remove(this);
        }
    }

    @Override
    public int getWidth() {
        return EXPLODEW;
    }

    @Override
    public int getHeight() {
        return EXPLODEH;
    }


}
