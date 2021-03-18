package com.shilei.tank.dp.abstractfactory;

import com.shilei.tank.ResourceMgr;

import java.awt.image.BufferedImage;

public class NewSuiteExplode extends AbstractExplode {
    private static NewSuiteExplode img = new NewSuiteExplode();
    private NewSuiteExplode() {}
    public static NewSuiteExplode getInstance() {
        return img;
    }
    @Override
    public BufferedImage[] explodes() {
        return ResourceMgr.explodes2;
    }
}
