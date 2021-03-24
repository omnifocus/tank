package com.shilei.dp.prototype;

public class Person implements Cloneable{
    private String name;
    private int age;
    private Location location;

    public Person(String name, int age, Location location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Location location = new Location("bj");
        Person p1 = new Person("lei",30,location);
        Person p2 = (Person) p1.clone();
        System.out.println(p1 == p2); //false
        System.out.println(p1.location == p2.location); //true
    }

}

class Location {
    private String name;

    public Location(String name) {
        this.name = name;
    }
}