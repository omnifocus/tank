package com.shilei.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(300,500);
        f.setLocation(300,200);
        f.setResizable(false);
        f.setVisible(true);
        f.setTitle("Tank");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(-1);
            }
        });
    }
}
