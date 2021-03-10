package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.event.KeyEvent.*;

public class TankFrame extends Frame {
    int x=20,y=30;
    public TankFrame() {
        setSize(200,200);
        setLocation(300,200);
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
                switch (e.getKeyCode()) {
                    case VK_UP:
                        y -= 5;
                        break;
                    case VK_LEFT:
                        x -= 5;
                        break;
                    case VK_RIGHT:
                        x += 5;
                        break;
                    case VK_DOWN:
                        y += 5;
                        break;
                }
                repaint();

            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
    }
}
