package com.shilei.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Node{
    private List<Node> nodeList = new ArrayList<>();
    private String content;

    public Branch(String content) {
        this.content = content;
    }

    @Override
    void print() {
        System.out.println(content);
    }

    public void addNode(Node node) {
        this.nodeList.add(node);
    }

    public List<Node> getNodeList() {
        return nodeList;
    }
}
