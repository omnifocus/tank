package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.event.KeyEvent.*;

public class TankFrame extends Frame {
    boolean isUp,isDown,isLeft,isRight;
    Dir dir = Dir.Down;
    int speed = 5;
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
                        isUp = true;
                        break;
                    case VK_LEFT:
                        isLeft = true;
                        break;
                    case VK_RIGHT:
                        isRight = true;
                        break;
                    case VK_DOWN:
                        isDown = true;
                        break;
                }
                setDir();

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case VK_UP:
                        isUp = false;
                        break;
                    case VK_LEFT:
                        isLeft = false;
                        break;
                    case VK_RIGHT:
                        isRight = false;
                        break;
                    case VK_DOWN:
                        isDown = false;
                        break;
                }
//                setDir();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        //这样写 一松手就停了
//        if (isUp)
//            y -= 5;
//        if (isDown)
//            y += 5;
//
//        if (isLeft)
//            x -= 5;
//
//        if (isRight)
//            x += 5;



        if (dir == Dir.Up) {
            y -= 5;
        } else if (dir == Dir.Down) {
            y += 5;
        } else if (dir == Dir.Left) {
            x -= 5;
        } else if (dir == Dir.Right) {
            x += 5;
        } else if (dir == Dir.UL) {
            x -= 5;
            y -= 5;
        } else if (dir == Dir.UR) {
            x += 5;
            y -= 5;
        } else if (dir == Dir.DL) {
            y += 5;
            x -= 5;
        } else {
            y += 5;
            x += 5;
        }

        g.fillRect(x,y,50,50);
    }


    private void setDir() {
        if (isUp && isLeft) {
            dir = Dir.UL;
        }
        if (isUp && isRight) {
            dir = Dir.UR;
        }

        if (isDown && isLeft) {
            dir = Dir.DL;
        }

        if(isDown && isRight) {
            dir = Dir.DR;
        }

        if (isUp) {
            dir = Dir.Up;
        }

        if (isDown) {
            dir = Dir.Down;
        }

        if (isLeft) {
            dir = Dir.Left;
        }
        if (isRight)
            dir = Dir.Right;
        }

}
