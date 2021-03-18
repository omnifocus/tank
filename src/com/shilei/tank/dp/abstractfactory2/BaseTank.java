package com.shilei.tank.dp.abstractfactory2;

import com.shilei.tank.Group;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public abstract class BaseTank {
    public Group group = Group.BAD;
    public Rectangle rectangle;
    public int x, y;

    public abstract void draw(Graphics g);

    public abstract void handleKeyPressed(KeyEvent e);

    public abstract void handleKeyReleased(KeyEvent e);

    public abstract void die();
}
