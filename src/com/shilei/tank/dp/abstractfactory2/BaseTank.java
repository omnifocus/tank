package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.Dir;
import com.shilei.tank.GameModel;
import com.shilei.tank.Group;
import com.shilei.tank.TankFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public abstract class BaseTank {
    public Group group = Group.BAD;
    public Rectangle rectangle;
    public int x, y;
    public Dir dir;
    public GameModel gm;

    public abstract void draw(Graphics g);

    public abstract void handleKeyPressed(KeyEvent e);

    public abstract void handleKeyReleased(KeyEvent e);

    public abstract void die();
}
