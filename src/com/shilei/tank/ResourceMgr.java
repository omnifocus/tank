package com.shilei.tank;

import com.shilei.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage u,d,l,r,ul,ur,dl,dr;
    public static BufferedImage u2,d2,l2,r2,ul2,ur2,dl2,dr2;
    public static BufferedImage mu,md,ml,mr,mul,mur,mdl,mdr;
    public static BufferedImage mu2,md2,ml2,mr2,mul2,mur2,mdl2,mdr2;
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

            u2 = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("BadTank2.png"));
            d2 = ImageUtil.rotateImage(u2,180);
            l2 = ImageUtil.rotateImage(u2,-90);
            r2 = ImageUtil.rotateImage(u2,90);
            ul2 = ImageUtil.rotateImage(u2,-45);
            ur2 = ImageUtil.rotateImage(u2,45);
            dl2 = ImageUtil.rotateImage(u2,-135);
            dr2 = ImageUtil.rotateImage(u2,135);



            bu = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("bulletU.png"));
            bd = ImageUtil.rotateImage(bu,180);
            bl = ImageUtil.rotateImage(bu,-90);
            br = ImageUtil.rotateImage(bu,90);
            bul = ImageUtil.rotateImage(bu,-45);
            bur = ImageUtil.rotateImage(bu,45);
            bdl = ImageUtil.rotateImage(bu,-135);
            bdr = ImageUtil.rotateImage(bu,135);


            mu = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("GoodTank1.png"));
            md = ImageUtil.rotateImage(mu,180);
            ml = ImageUtil.rotateImage(mu,-90);
            mr = ImageUtil.rotateImage(mu,90);
            mul = ImageUtil.rotateImage(mu,-45);
            mur = ImageUtil.rotateImage(mu,45);
            mdl = ImageUtil.rotateImage(mu,-135);
            mdr = ImageUtil.rotateImage(mu,135);

            mu2= ImageIO.read(Main.class.getClassLoader().getResourceAsStream("GoodTank2.png"));
            md2= ImageUtil.rotateImage(mu2,180);
            ml2= ImageUtil.rotateImage(mu2,-90);
            mr2= ImageUtil.rotateImage(mu2,90);
            mul2 = ImageUtil.rotateImage(mu2,-45);
            mur2 = ImageUtil.rotateImage(mu2,45);
            mdl2 = ImageUtil.rotateImage(mu2,-135);
            mdr2 = ImageUtil.rotateImage(mu2,135);

            for (int i=0;i<=15;i++) {
                explodes[i] = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
