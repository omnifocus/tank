package com.shilei.dp.strategy;

import java.util.Comparator;

public class CatFoodComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.food - o2.food;
    }
}
