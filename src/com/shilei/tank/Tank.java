package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_DOWN;

public class Tank {
    boolean isUp, isDown, isLeft, isRight;
    Dir dir = Dir.Down;
    int x = 20, y = 30;
    //增加是否移动属性
    boolean isMoving;
    public static final int TankW = 50;
    public static final int TankH = 50;
    public static final int TANK_SPEED = 5;
    TankFrame tankFrame;
    boolean isAlive = true;
    boolean isMainTank;

    public Tank(int x, int y,Dir dir, boolean isMainTank, TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.isMainTank = isMainTank;
        this.tankFrame = tankFrame;
    }

    void draw(Graphics g) {
        if (!isAlive && !isMainTank) {
            tankFrame.enemyTanks.remove(this);
        }
        Color originColor = g.getColor();
        if (isMainTank)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.green);
        g.fillRect(x, y, TankW,TankH);
        g.setColor(originColor);
        //画完再移动
        move();
    }

    private void move() {
        //移动状态下画出来才有效果
        if (!isMoving)
            return;
        if (dir == Dir.Up) {
            y -= TANK_SPEED;
        } else if (dir == Dir.Down) {
            y += TANK_SPEED;
        } else if (dir == Dir.Left) {
            x -= TANK_SPEED;
        } else if (dir == Dir.Right) {
            x += TANK_SPEED;
        } else if (dir == Dir.UL) {
            x -= TANK_SPEED;
            y -= TANK_SPEED;
        } else if (dir == Dir.UR) {
            x += TANK_SPEED;
            y -= TANK_SPEED;
        } else if (dir == Dir.DL) {
            y += TANK_SPEED;
            x -= TANK_SPEED;
        } else if (dir == Dir.DR) {
            y += TANK_SPEED;
            x += TANK_SPEED;
        }

    }

    private void setDir() {
        if (isUp && !isDown && !isLeft && !isRight)
            dir = Dir.Up;
        if (!isUp && isDown && !isLeft && !isRight)
            dir = Dir.Down;
        if (!isUp && !isDown && isLeft && !isRight)
            dir = Dir.Left;
        if (!isUp && !isDown && !isLeft && isRight)
            dir = Dir.Right;

        if (isUp && isLeft && !isRight && !isDown) {
            dir = Dir.UL;
        }
        if (isUp && isRight && !isLeft && !isDown) {
            dir = Dir.UR;
        }

        if (isDown && isLeft && !isUp && !isRight) {
            dir = Dir.DL;
        }

        if (isDown && isRight && !isUp && !isLeft) {
            dir = Dir.DR;
        }
        // 无需通过方向判断是否Stop

    }


    public void handleKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_UP:
                isUp = true;
                break;
            case VK_LEFT:
                isLeft = true;
                break;
            case VK_RIGHT:
                isRight = true;
                break;
            case VK_DOWN:
                isDown = true;
                break;
        }
        setDir();
        isMoving = true;

    }

    public void handleKeyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_UP:
                isUp = false;
                break;
            case VK_LEFT:
                isLeft = false;
                break;
            case VK_RIGHT:
                isRight = false;
                break;
            case VK_DOWN:
                isDown = false;
                break;

            case VK_CONTROL:
                fire();
                break;
        }
        setDir();
        isMoving = false;
    }

    private void fire() {
      Bullet bullet = new Bullet(x + TankW/2,y+TankH/2,dir,this.tankFrame);
      this.tankFrame.bullets.add(bullet);
    }
}
