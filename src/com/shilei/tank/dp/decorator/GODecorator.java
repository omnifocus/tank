package com.shilei.tank.dp.decorator;

import com.shilei.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject {
    protected GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

}
