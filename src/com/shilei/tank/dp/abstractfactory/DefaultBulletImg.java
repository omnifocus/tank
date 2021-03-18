package com.shilei.tank.dp.abstractfactory;

import com.shilei.tank.ResourceMgr;

import java.awt.image.BufferedImage;

public class DefaultBulletImg extends AbstractImage {
    private static DefaultBulletImg img = new DefaultBulletImg();
    private DefaultBulletImg() {}
    public static DefaultBulletImg getInstance() {
        return img;
    }

    @Override
    public BufferedImage u() {
        return ResourceMgr.bu;
    }

    @Override
    public BufferedImage d() {
        return ResourceMgr.bd;
    }

    @Override
    public BufferedImage l() {
        return ResourceMgr.bl;
    }

    @Override
    public BufferedImage r() {
        return ResourceMgr.br;
    }

    @Override
    public BufferedImage ul() {
        return ResourceMgr.bul;
    }

    @Override
    public BufferedImage ur() {
        return ResourceMgr.bur;
    }

    @Override
    public BufferedImage dl() {
        return ResourceMgr.bdl;
    }

    @Override
    public BufferedImage dr() {
        return ResourceMgr.bdr;
    }

    @Override
    public int width() {
        return ResourceMgr.bu.getWidth();
    }

    @Override
    public int height() {
        return ResourceMgr.bu.getHeight();
    }
}
