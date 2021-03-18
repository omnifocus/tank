package com.shilei.tank.dp.abstractfactory;

import com.shilei.tank.ResourceMgr;

import java.awt.image.BufferedImage;

public class NewSuiteBulletImg extends AbstractImage {
    private static NewSuiteBulletImg img = new NewSuiteBulletImg();
    private NewSuiteBulletImg() {}
    public static NewSuiteBulletImg getInstance() {
        return img;
    }

    @Override
    public BufferedImage u() {
        return ResourceMgr.bu2;
    }

    @Override
    public BufferedImage d() {
        return ResourceMgr.bd2;
    }

    @Override
    public BufferedImage l() {
        return ResourceMgr.bl2;
    }

    @Override
    public BufferedImage r() {
        return ResourceMgr.br2;
    }

    @Override
    public BufferedImage ul() {
        return ResourceMgr.bul2;
    }

    @Override
    public BufferedImage ur() {
        return ResourceMgr.bur2;
    }

    @Override
    public BufferedImage dl() {
        return ResourceMgr.bdl2;
    }

    @Override
    public BufferedImage dr() {
        return ResourceMgr.bdr2;
    }

    @Override
    public int width() {
        return ResourceMgr.bd2.getWidth();
    }

    @Override
    public int height() {
        return ResourceMgr.bd2.getHeight();
    }
}
