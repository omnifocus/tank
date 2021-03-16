package com.shilei.tank;

import com.shilei.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage u,d,l,r,ul,ur,dl,dr;
    public static BufferedImage bu,bd,bl,br,bul,bur,bdl,bdr;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static  {
        try {
            u = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("BadTank1.png"));
            d = ImageUtil.rotateImage(u,180);
            l = ImageUtil.rotateImage(u,-90);
            r = ImageUtil.rotateImage(u,90);
            ul = ImageUtil.rotateImage(u,-45);
            ur = ImageUtil.rotateImage(u,45);
            dl = ImageUtil.rotateImage(u,-135);
            dr = ImageUtil.rotateImage(u,135);

            bu = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("bulletU.png"));
            bd = ImageUtil.rotateImage(bu,180);
            bl = ImageUtil.rotateImage(bu,-90);
            br = ImageUtil.rotateImage(bu,90);
            bul = ImageUtil.rotateImage(bu,-45);
            bur = ImageUtil.rotateImage(bu,45);
            bdl = ImageUtil.rotateImage(bu,-135);
            bdr = ImageUtil.rotateImage(bu,135);

            for (int i=0;i<=15;i++) {
                explodes[i] = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
