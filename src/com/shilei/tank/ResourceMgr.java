package com.shilei.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage u,d,l,r,ul,ur,dl,dr;
    public static BufferedImage bu,bd,bl,br,bul,bur,bdl,bdr;
    public static BufferedImage[] explodes = new BufferedImage[16];

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

            bu = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("bulletU.gif"));
            bd = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("bulletD.gif"));
            bl = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("bulletL.gif"));
            br = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("bulletR.gif"));
            bul = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("missileLU.gif"));
            bur = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("missileRU.gif"));
            bdl = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("missileLD.gif"));
            bdr = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("missileRD.gif"));

            for (int i=0;i<=15;i++) {
                explodes[i] = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
