package com.shilei.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage u,d,l,r;

    static  {
        try {
            u = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankU.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
