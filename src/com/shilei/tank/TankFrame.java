package com.shilei.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
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
        g.fillRect(100,100,50,50);
    }
}
