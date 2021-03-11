package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_CONTROL;

public class Bullet {
    private int x,y;
    public static final int BULLETW = 5;
    public static final int BULLETH = 5;
    public static final int BULLET_SPEED = 10;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void draw(Graphics g) {
        Color originColor = g.getColor();
        g.fillOval(x,y,BULLETW,BULLETH);
        g.setColor(originColor);
        move();
    }

    private void move() {
        if (dir == Dir.Up) {
            y -= BULLET_SPEED;
        } else if (dir == Dir.Down) {
            y += BULLET_SPEED;
        } else if (dir == Dir.Left) {
            x -= BULLET_SPEED;
        } else if (dir == Dir.Right) {
            x += BULLET_SPEED;
        } else if (dir == Dir.UL) {
            x -= BULLET_SPEED;
            y -= BULLET_SPEED;
        } else if (dir == Dir.UR) {
            x += BULLET_SPEED;
            y -= BULLET_SPEED;
        } else if (dir == Dir.DL) {
            y += BULLET_SPEED;
            x -= BULLET_SPEED;
        } else if (dir == Dir.DR) {
            y += BULLET_SPEED;
            x += BULLET_SPEED;
        }

    }


}
