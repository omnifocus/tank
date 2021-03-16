package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import static java.awt.event.KeyEvent.VK_CONTROL;

public class Bullet {
    private int x,y;
    public static final int BULLETW = ResourceMgr.bu.getWidth();
    public static final int BULLETH = ResourceMgr.bu.getHeight();
    public static final int BULLET_SPEED = 10;
    private Dir dir;
    private TankFrame tf;
    boolean isAlive = true;
    private Group group = Group.BAD;
    Rectangle rectangle = new Rectangle(x,y,BULLETW,BULLETH);

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void draw(Graphics g) {
        if (!isAlive)
            this.tf.bullets.remove(this);
        switch (dir) {
            case Up:
                g.drawImage(ResourceMgr.bu,x,y,null);
                break;
            case Down:
                g.drawImage(ResourceMgr.bd,x,y,null);
                break;
            case Left:
                g.drawImage(ResourceMgr.bl,x,y,null);
                break;
            case Right:
                g.drawImage(ResourceMgr.br,x,y,null);
                break;
            case UL:
                g.drawImage(ResourceMgr.bul,x,y,null);
                break;
            case UR:
                g.drawImage(ResourceMgr.bur,x,y,null);
                break;
            case DL:
                g.drawImage(ResourceMgr.bdl,x,y,null);
                break;
            case DR:
                g.drawImage(ResourceMgr.bdr,x,y,null);
                break;
        }
        move();
        rectangle.x = x;
        rectangle.y = y;
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
        //只用获取TankFrame，不需要持有引用
        if (x <= 0 || x >= TankFrame.frameW || y <=0 || y >= TankFrame.frameH) {
            //会报java.util.ConcurrentModificationException
//            tf.bullets.remove(this);
            this.isAlive = false;
        }

    }


    public void collide(Tank tank) {
        if (group == tank.group) return;
        if (this.rectangle.intersects(tank.rectangle)) {
            tf.explodes.add(new Explode(tank.x ,tank.y ,tf));
            this.die();
            tank.die();
        }
    }

    private void die() {
        isAlive = false;
    }
}
