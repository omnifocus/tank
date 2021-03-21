package com.shilei.util;

import com.shilei.tank.Dir;

import java.util.Random;

public class RandomDir {
    public static Dir randomDir() {
        int random = new Random().nextInt(Dir.values().length);
        return Dir.values()[random];
    }
}
