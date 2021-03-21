package com.shilei.dp.flyweight;

public class Connection {
    private String name;

    public Connection(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "name='" + name + '\'' +
                '}';
    }
}
