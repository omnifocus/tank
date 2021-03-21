package com.shilei.dp.listener;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private String name;
    private List<MyActionListener> listeners = new ArrayList<>();
    public Child(String name) {
        this.name = name;
    }

    public void wakeup() {
        MyEvent<Child> e = new MyEvent<>(System.currentTimeMillis(),"bj",this);

        for (MyActionListener listener: listeners) {
            listener.dosomething(e);
        }
    }

    public void addListener(MyActionListener listener) {
        listeners.add(listener);
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }
}
