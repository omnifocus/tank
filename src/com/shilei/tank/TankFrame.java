package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import static java.awt.event.KeyEvent.*;

public class TankFrame extends Frame {
    public static final int frameW = 500, frameH = 500;
    int x = 300, y = 200;
    Tank tank = new Tank(x,y,Dir.Right,this);
    java.util.List<Bullet> bullets = new ArrayList<>();

    public TankFrame() {
        setSize(frameW, frameH);
        setLocation(x, y);
        setVisible(true);
        setResizable(false);
        setTitle("TankWar");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tank.handleKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
               tank.handleKeyReleased(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Color originColor = g.getColor();
        g.setColor(Color.black);
        g.fillRect(0,0,frameW,frameH);
        g.setColor(Color.orange);
        g.drawString("当前子弹数量：" + bullets.size(),10,50);
        tank.draw(g);

        final Iterator<Bullet> iterator = bullets.iterator();
//        while (iterator.hasNext()) {
//            final Bullet b = iterator.next();
//            if (!b.isAlive) {
//                iterator.remove();
//            }
//            b.draw(g);
//        }
        for (int i=0;i<bullets.size();i++)
            bullets.get(i).draw(g);

        g.setColor(originColor);
    }


//    Image offScreenImage ;
//
//    @Override
//    public void update(Graphics g) {
//        if (offScreenImage == null) {
//            offScreenImage = this.createImage(frameW,frameH);
//        }
//        Graphics gOffscreen = offScreenImage.getGraphics();
//        Color c = gOffscreen.getColor();
//        gOffscreen.setColor(Color.BLACK);
//        gOffscreen.fillRect(0,0,frameW,frameH);
//        gOffscreen.setColor(c);
//        paint(gOffscreen);
//        g.drawImage(offScreenImage,0,0,null);
//    }
}
