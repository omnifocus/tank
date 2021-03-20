package com.shilei.tank;

import com.shilei.util.RandomDir;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static java.awt.event.KeyEvent.*;

public class TankFrame extends Frame {
    GameModel gm = new GameModel();
    public static final int frameW = 1200, frameH = 600;
    int x = 150, y = 100;

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
                gm.tank.handleKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gm.tank.handleKeyReleased(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        gm.draw(g);
    }


    Image offScreenImage;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(frameW, frameH);
        }
        Graphics gOffscreen = offScreenImage.getGraphics();
        Color c = gOffscreen.getColor();
        gOffscreen.setColor(Color.WHITE);
        gOffscreen.fillRect(0, 0, frameW, frameH);
        gOffscreen.setColor(c);
        paint(gOffscreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
