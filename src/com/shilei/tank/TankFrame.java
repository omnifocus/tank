package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.event.KeyEvent.*;

public class TankFrame extends Frame {
    boolean isUp, isDown, isLeft, isRight;
    Dir dir = Dir.Down;
    int speed = 5;
    int x = 20, y = 30;

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
                setDir();
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
            y -= speed;
        } else if (dir == Dir.Down) {
            y += speed;
        } else if (dir == Dir.Left) {
            x -= speed;
        } else if (dir == Dir.Right) {
            x += speed;
        } else if (dir == Dir.UL) {
            x -= speed;
            y -= speed;
        } else if (dir == Dir.UR) {
            x += speed;
            y -= speed;
        } else if (dir == Dir.DL) {
            y += speed;
            x -= speed;
        } else if (dir == Dir.DR) {
            y += speed;
            x += speed;
        } else if (dir == Dir.Stop) {
            //do nothing
        }


        g.fillRect(x, y, 50, 50);
    }


    private void setDir() {
        if (isUp && !isDown && !isLeft && !isRight)
            dir = Dir.Up;
        if (!isUp && isDown && !isLeft && !isRight)
            dir = Dir.Down;
        if (!isUp && !isDown && isLeft && !isRight)
            dir = Dir.Left;
        if (!isUp && !isDown && !isLeft && isRight)
            dir = Dir.Right;

        if (isUp && isLeft && !isRight && !isDown) {
            dir = Dir.UL;
        }
        if (isUp && isRight && !isLeft && !isDown) {
            dir = Dir.UR;
        }

        if (isDown && isLeft && !isUp && !isRight) {
            dir = Dir.DL;
        }

        if (isDown && isRight && !isUp && !isLeft) {
            dir = Dir.DR;
        }

        if((! isUp &&!isDown &&!isLeft && !isRight) ||(isUp && isDown) || (isLeft && isRight) ) {
            dir = Dir.Stop;
        }

    }

}
