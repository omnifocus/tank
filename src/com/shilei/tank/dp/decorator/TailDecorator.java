package com.shilei.tank.dp.decorator;

import com.shilei.tank.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator{

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void draw(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.draw(g);
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawLine(x,y,x+getWidth(),y+getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
