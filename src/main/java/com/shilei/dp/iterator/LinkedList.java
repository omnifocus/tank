package com.shilei.dp.iterator;

public class LinkedList<T> implements List<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    @Override
    public void add(T e) {
        Node<T> node = new Node(e,null);
        if (head == null /* && tail == null*/) {
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
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node<T> node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                Node<T> node_ = node;
                node = node.node;
                return node_.o;
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

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
class Node<T> {
    T o;
    Node node;

    public Node(T o, Node node) {
        this.o = o;
        this.node = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "o=" + o +
                '}';
    }
}