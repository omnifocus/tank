package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.event.KeyEvent.*;

public class TankFrame extends Frame {
    Tank tank = new Tank();
    Bullet bullet = new Bullet(50,50,Dir.Right);


    public TankFrame() {
        setSize(200, 200);
        setLocation(300, 200);
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
        tank.draw(g);
        bullet.draw(g);
    }






}
