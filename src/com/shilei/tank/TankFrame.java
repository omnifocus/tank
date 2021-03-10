package com.shilei.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    }

    @Override
    public void paint(Graphics g) {
        x+=10;
        y+=10;
        g.fillRect(x,y,50,50);
    }
}
