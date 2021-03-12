package com.shilei.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage u,d,l,r,ul,ur,dl,dr;

    static  {
        try {
            u = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankU.gif"));
            d = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankD.gif"));
            l = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankL.gif"));
            r = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankR.gif"));
            ul = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankLU.gif"));
            ur = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankRU.gif"));
            dl = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankLD.gif"));
            dr = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("tankRD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
