package com.shilei.dp.composite;

public class Leaf extends Node{
    private String content;

    public Leaf(String content) {
        this.content = content;
    }

    @Override
    void print() {
        System.out.println(content);
    }
}
