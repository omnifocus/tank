package com.shilei.tank.dp.abstractfactory;

import com.shilei.tank.ResourceMgr;

import java.awt.image.BufferedImage;

public class DefaultExplode extends AbstractExplode {
    private static DefaultExplode img = new DefaultExplode();
    private DefaultExplode() {}
    public static DefaultExplode getInstance() {
        return img;
    }
    @Override
    public BufferedImage[] explodes() {
        return ResourceMgr.explodes;
    }
}
