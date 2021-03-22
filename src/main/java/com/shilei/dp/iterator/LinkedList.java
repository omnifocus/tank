package com.shilei.dp.iterator;

public class LinkedList implements List{
    private Node head;
    private Node tail;
    private int size;
    @Override
    public void add(Object e) {
        Node node = (Node) e;
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.node = node;
            tail = node;
        }
        size ++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            Node node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Object next() {
                Node node_ = node;
                node = node.node;
                return node_;
            }
        };
    }


    public static void main(String[] args) {
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,null);
        Node node3 = new Node(3,null);
        Node node4 = new Node(4,null);
        List linkedList = new LinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
class Node {
    Object o;
    Node node;

    public Node(Object o, Node node) {
        this.o = o;
        this.node = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "o=" + o +
                ", node=" + node +
                '}';
    }
}
