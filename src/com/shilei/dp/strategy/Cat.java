package com.shilei.dp.strategy;

public class Cat {
    int weight;
    int food;

    public Cat(int weight,int food) {
        this.weight = weight;
        this.food = food;
    }

//    @Override
    public int compareTo(Object o) {
        Cat c = (Cat) o;
        return weight-c.weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", food=" + food +
                '}';
    }
}
