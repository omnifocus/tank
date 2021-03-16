package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_DOWN;

public class Tank {
    boolean isUp, isDown, isLeft, isRight;
    Dir dir = Dir.Down;
    int x = 20, y = 30;
    //增加是否移动属性
    boolean isMoving = true;
    public static final int TankW = ResourceMgr.u.getWidth();
    public static final int TankH = ResourceMgr.u.getHeight();
    public static final int TANK_SPEED = 1;
    TankFrame tankFrame;
    boolean isAlive = true;
    Group group = Group.BAD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    /**
     * 默认生成bad tank
     * @param x
     * @param y
     * @param dir
     * @param tankFrame
     */
    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    void draw(Graphics g) {
        if (!isAlive && group == Group.BAD) {
            tankFrame.enemyTanks.remove(this);
        }
        switch (dir) {
            case Up:
                g.drawImage(ResourceMgr.u, x, y, null);
                break;
            case Down:
                g.drawImage(ResourceMgr.d, x, y, null);
                break;
            case Left:
                g.drawImage(ResourceMgr.l, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceMgr.r, x, y, null);
                break;
            case UL:
                g.drawImage(ResourceMgr.ul, x, y, null);
                break;
            case UR:
                g.drawImage(ResourceMgr.ur, x, y, null);
                break;
            case DL:
                g.drawImage(ResourceMgr.dl, x, y, null);
                break;
            case DR:
                g.drawImage(ResourceMgr.dr, x, y, null);
                break;
        }

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
        //随机让敌方坦克发子弹！
        if(group == Group.BAD && new Random().nextInt(10) > 8) {
            fire();
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
                isMoving = true;
                break;
            case VK_LEFT:
                isLeft = true;
                isMoving = true;
                break;
            case VK_RIGHT:
                isRight = true;
                isMoving = true;
                break;
            case VK_DOWN:
                isDown = true;
                isMoving = true;
                break;
        }
        setDir();


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

            case VK_F1:
                fire();
                break;
        }
        setDir();
        isMoving = false;
    }

    private void fire() {
//        System.out.println(String.format("%s %s %s %s %s %s", x, y,TankW,TankH,Bullet.BULLETW,Bullet.BULLETH));
        int bX = x + TankW / 2 - Bullet.BULLETW / 2;
        int bY = y + TankH / 2 - Bullet.BULLETH / 2;
        Bullet bullet = new Bullet(bX, bY, dir, group, this.tankFrame);
        this.tankFrame.bullets.add(bullet);
    }
}
