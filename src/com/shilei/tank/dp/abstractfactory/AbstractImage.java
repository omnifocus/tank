package com.shilei.tank.dp.abstractfactory;

import java.awt.image.BufferedImage;

public abstract class AbstractImage {
    public abstract BufferedImage u();
    public abstract BufferedImage d();
    public abstract BufferedImage l();
    public abstract BufferedImage r();
    public abstract BufferedImage ul();
    public abstract BufferedImage ur();
    public abstract BufferedImage dl();
    public abstract BufferedImage dr();
    public abstract int width();
    public abstract int height();

}
