package com.shilei.tank;

import com.shilei.tank.dp.abstractfactory.AbstractFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Method;

import static java.awt.event.KeyEvent.VK_CONTROL;

public class Bullet {
    private int x,y;
    public static  int BULLETW ;
    public static  int BULLETH ;
    public static final int BULLET_SPEED = 10;
    private Dir dir;
    private TankFrame tf;
    boolean isAlive = true;
    private Group group = Group.BAD;
    Rectangle rectangle = new Rectangle(x,y,BULLETW,BULLETH);
    static AbstractFactory abstractFactory;
    static {
        try {
            Class clazz3 = Class.forName(PropertyMgr.get("factory"));
            Method method3 = clazz3.getMethod("getInstance");
            abstractFactory = (AbstractFactory) method3.invoke(clazz3);
            BULLETW = abstractFactory.createBulletImg().width();
            BULLETH = abstractFactory.createBulletImg().height();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        tf.bullets.add(this);
    }

    public void draw(Graphics g) {
        if (!isAlive)
            this.tf.bullets.remove(this);
        switch (dir) {
            case Up:
                g.drawImage(abstractFactory.createBulletImg().u(),x,y,null);
                break;
            case Down:
                g.drawImage(abstractFactory.createBulletImg().d(),x,y,null);
                break;
            case Left:
                g.drawImage(abstractFactory.createBulletImg().l(),x,y,null);
                break;
            case Right:
                g.drawImage(abstractFactory.createBulletImg().r(),x,y,null);
                break;
            case UL:
                g.drawImage(abstractFactory.createBulletImg().ul(),x,y,null);
                break;
            case UR:
                g.drawImage(abstractFactory.createBulletImg().ur(),x,y,null);
                break;
            case DL:
                g.drawImage(abstractFactory.createBulletImg().dl(),x,y,null);
                break;
            case DR:
                g.drawImage(abstractFactory.createBulletImg().dr(),x,y,null);
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
