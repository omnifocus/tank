package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.*;

import java.awt.*;

public class RectBullet extends BaseBullet {
    private int x,y;
    public static  int BULLETW = ResourceMgr.bd.getWidth();
    public static  int BULLETH = ResourceMgr.bd.getHeight();
    public static final int BULLET_SPEED = 10;
    private Dir dir;
    private GameModel gm;
    boolean isAlive = true;
    private Group group = Group.BAD;



    public RectBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;
        gm.bullets.add(this);
        this.rectangle = new Rectangle(x,y,BULLETW,BULLETH);
    }

    public void draw(Graphics g) {
        if (!isAlive)
            this.gm.bullets.remove(this);
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x,y,BULLETW,BULLETH);
        g.setColor(c);
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


    public void collide(BaseTank tank) {
        if (group == tank.group) return;
        if (this.rectangle.intersects(tank.rectangle)) {
            gm.explodes.add(GameModel.abstractFactory.genExplode(tank.x,tank.y,gm));
            this.die();
            tank.die();
        }
    }

    private void die() {
        isAlive = false;
    }
}
