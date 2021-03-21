package com.shilei.tank.dp.listener;

import com.shilei.tank.Tank;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class MyFireListener implements FireListener {
    @Override
    public void doFire(MyEvent event) {
        KeyEvent e = event.event;
        Tank tank = event.source;
        switch (e.getKeyCode()) {
            case VK_UP:
                tank.isUp = false;
                break;
            case VK_LEFT:
                tank.isLeft = false;
                break;
            case VK_RIGHT:
                tank.isRight = false;
                break;
            case VK_DOWN:
                tank.isDown = false;
                break;

            case VK_F1:
                tank.fire(Tank.fireStrategyGoodTank);
                break;
        }
    }
}
