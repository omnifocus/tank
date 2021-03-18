package com.shilei.tank;

import com.shilei.tank.dp.abstractfactory2.BaseTank;
import com.shilei.tank.dp.strategy.FireStrategy;
import com.shilei.util.RandomDir;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import static java.awt.event.KeyEvent.*;

public class Tank extends BaseTank {
    boolean isUp, isDown, isLeft, isRight;
    public Dir dir = Dir.Down;
    //增加是否移动属性
    boolean isMoving = true;

    public static final int TANK_SPEED = 5;
    public TankFrame tankFrame;
    boolean isAlive = true;
    public Group group = Group.BAD;
    public static FireStrategy fireStrategyGoodTank;
    public static FireStrategy fireStrategyBadTank;

    public static  int TankW = ResourceMgr.u.getWidth();
    public static  int TankH = ResourceMgr.u.getHeight();

    static {
        try {
            Class clazz  =  Class.forName(PropertyMgr.get("FireStrategyGoodTank"));
            Method method =  clazz.getMethod("getInstance");
            fireStrategyGoodTank = (FireStrategy) method.invoke(clazz);

            Class clazz2  =  Class.forName(PropertyMgr.get("FireStrategyBadTank"));
            Method method2 =  clazz2.getMethod("getInstance");
            fireStrategyBadTank = (FireStrategy) method2.invoke(clazz2);


        } catch (ClassNotFoundException | NoSuchMethodException  | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    int step;
    int threshold = 2;


    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.group = group;
        this.tankFrame = tankFrame;
        //为啥不能放外面
        rectangle = new  Rectangle(x,y,TankW,TankH);
    }

    @Override
    public void draw(Graphics g) {
        if (!isAlive && group == Group.BAD) {
            tankFrame.enemyTanks.remove(this);
        }
        if (group == Group.BAD) {
            switch (dir) {
                case Up:
                    g.drawImage(ResourceMgr.u ,x,  y, null);
                    break;
                case Down:
                    g.drawImage( ResourceMgr.d,x,y, null);
                    break;
                case Left:
                    g.drawImage( ResourceMgr.l,x,  y, null);
                    break;
                case Right:
                    g.drawImage( ResourceMgr.r,x,  y, null);
                    break;
                case UL:
                    g.drawImage( ResourceMgr.ul,x, y, null);
                    break;
                case UR:
                    g.drawImage( ResourceMgr.ur,x, y, null);
                    break;
                case DL:
                    g.drawImage( ResourceMgr.dl,x, y, null);
                    break;
                case DR:
                    g.drawImage( ResourceMgr.dr,x,y, null);
                    break;
            }
        } else {
            switch (dir) {
                case Up:
                    g.drawImage( ResourceMgr.mu,x, y, null);
                    break;
                case Down:
                    g.drawImage( ResourceMgr.md,x, y, null);
                    break;
                case Left:
                    g.drawImage(ResourceMgr.ml,x,y, null);
                    break;
                case Right:
                    g.drawImage(ResourceMgr.mr,x, y, null);
                    break;
                case UL:
                    g.drawImage(ResourceMgr.mul,x, y, null);
                    break;
                case UR:
                    g.drawImage(ResourceMgr.mur,x, y, null);
                    break;
                case DL:
                    g.drawImage(ResourceMgr.mdl,x, y, null);
                    break;
                case DR:
                    g.drawImage(ResourceMgr.mdr,x, y, null);
                    break;
            }
        }
        //画完再移动
        move();
        step++;
        if (step == 2) step = 0;
        rectangle.x = x;
        rectangle.y = y;
    }

    private void move() {
        //移动状态下画出来才有效果
        if (!isMoving)
            return;

        boundCheck();

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
        if(group == Group.BAD && new Random().nextInt(100) > 98) {
            //子弹只能发射跟随坦克方向的子弹
            fire(fireStrategyBadTank);
        }
        //敌方坦克随机方向
        if(group == Group.BAD && new Random().nextInt(100) > 98) {
            dir = RandomDir.randomDir();
        }

    }

    private void boundCheck() {

        if (group == Group.BAD) {


            if (x <= 0) {
                x = 0;
            }

            if (x >= TankFrame.frameW - Tank.TankW) {
                x = TankFrame.frameW - Tank.TankW;
            }

            if (y <= 30) {
                y = 30;
            }
            if (y >= TankFrame.frameH - Tank.TankH) {
                y = TankFrame.frameH - Tank.TankH;
            }

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
                fire(fireStrategyGoodTank);
                break;
        }
        setDir();
        isMoving = false;
    }

    private void fire(FireStrategy fs) {
        fs.fireWithTank(this);
    }

    public void die() {
        isAlive = false;
    }


}
