package com.shilei.tank.dp.abstractfactory;

import com.shilei.tank.ResourceMgr;

import java.awt.image.BufferedImage;

public class DefaultTankImage extends AbstractImage {
    private static DefaultTankImage img = new DefaultTankImage();
    private DefaultTankImage() {}
    public static DefaultTankImage getInstance() {
        return img;
    }
    @Override
    public BufferedImage u() {
        return ResourceMgr.u;
    }

    @Override
    public BufferedImage d() {
        return ResourceMgr.d;
    }

    @Override
    public BufferedImage l() {
        return ResourceMgr.l;
    }

    @Override
    public BufferedImage r() {
        return ResourceMgr.r;
    }

    @Override
    public BufferedImage ul() {
        return ResourceMgr.ul;
    }

    @Override
    public BufferedImage ur() {
        return ResourceMgr.ur;
    }

    @Override
    public BufferedImage dl() {
        return ResourceMgr.dl;
    }

    @Override
    public BufferedImage dr() {
        return ResourceMgr.dr;
    }

    @Override
    public int width() {
        return ResourceMgr.u.getWidth();
    }

    @Override
    public int height() {
        return ResourceMgr.u.getHeight();
    }
}
