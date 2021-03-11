package com.shilei.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_DOWN;

public class Tank {
    boolean isUp, isDown, isLeft, isRight;
    Dir dir = Dir.Down;
    int x = 20, y = 30;
    public static final int TankW = 50;
    public static final int TankH = 50;
    public static final int speed = 5;


    void draw(Graphics g) {
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

        g.fillRect(x, y, TankW,TankH);

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


    public void handleKeyPressed(KeyEvent e) {
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

    public void handleKeyReleased(KeyEvent e) {
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
}
