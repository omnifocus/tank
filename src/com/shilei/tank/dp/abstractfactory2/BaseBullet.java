package com.shilei.tank.dp.abstractfactory2;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void draw(Graphics g);

    public abstract void collide(BaseTank baseTank);
}
