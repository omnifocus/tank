package com.shilei.tank.dp.listener;

import com.shilei.tank.Tank;

import java.awt.event.KeyEvent;

public class MyEvent {
    public KeyEvent event;
    public Tank source;

    public MyEvent(KeyEvent event, Tank source) {
        this.event = event;
        this.source = source;
    }
}
