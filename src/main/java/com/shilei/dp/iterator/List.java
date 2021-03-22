package com.shilei.dp.iterator;

public interface List<T> {
    void add(T e);
    int getSize();
    Iterator<T> iterator();
}
