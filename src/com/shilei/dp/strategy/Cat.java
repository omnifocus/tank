package com.shilei.dp.strategy;

public class Cat implements Comparable{
    int weight;

    public Cat(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Cat c = (Cat) o;
        return weight-c.weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                '}';
    }
}
