package com.shilei.tank.dp.factory.abstractfactory;

public class Main {
    public static void main(String[] args) {
//        AbstractFactory factory = new ModernFactory();
        AbstractFactory factory = new MagicFactory();
        Food food = factory.createFood();
        Gun gun = factory.createWeapon();
        food.eat();
        gun.fire();
    }
}
