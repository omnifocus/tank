package com.shilei.tank.dp.strategy;

import com.shilei.tank.Tank;
import com.shilei.tank.dp.abstractfactory2.BaseTank;

public interface FireStrategy {
    void fireWithTank(BaseTank tank);
}
