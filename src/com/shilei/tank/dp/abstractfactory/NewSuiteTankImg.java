package com.shilei.tank.dp.abstractfactory;

import com.shilei.tank.ResourceMgr;

import java.awt.image.BufferedImage;

public class NewSuiteTankImg extends AbstractImage {
    private static NewSuiteTankImg img = new NewSuiteTankImg();
    private NewSuiteTankImg() {}
    public static NewSuiteTankImg getInstance() {
        return img;
    }
    @Override
    public BufferedImage u() {
        return ResourceMgr.mu;
    }

    @Override
    public BufferedImage d() {
        return ResourceMgr.md;
    }

    @Override
    public BufferedImage l() {
        return ResourceMgr.ml;
    }

    @Override
    public BufferedImage r() {
        return ResourceMgr.mr;
    }

    @Override
    public BufferedImage ul() {
        return ResourceMgr.mul;
    }

    @Override
    public BufferedImage ur() {
        return ResourceMgr.mur;
    }

    @Override
    public BufferedImage dl() {
        return ResourceMgr.mdl;
    }

    @Override
    public BufferedImage dr() {
        return ResourceMgr.mdr;
    }

    @Override
    public int width() {
        return ResourceMgr.md.getWidth();
    }

    @Override
    public int height() {
        return ResourceMgr.md.getHeight();
    }
}
