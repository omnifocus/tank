package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_CONTROL;

public class Bullet {
    private int x,y;
    public static final int BULLETW = 10;
    public static final int BULLETH = 10;
    public static final int BULLET_SPEED = 10;
    private Dir dir;
    private TankFrame tf;
    boolean isAlive = true;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void draw(Graphics g) {
        Color originColor = g.getColor();
        g.setColor(Color.RED);
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

        if (x <= 0 || x >= tf.frameW || y <=0 || y >= tf.frameH) {
            //会报java.util.ConcurrentModificationException
//            tf.bullets.remove(this);
            this.isAlive = false;
        }

    }


}
