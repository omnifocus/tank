package com.shilei.dp.composite;

public class Main {
    public static void main(String[] args) {
        Branch root = new Branch("root");
        Branch b1 = new Branch("b1");
        Branch b2 = new Branch("b2");
        Leaf l11 = new Leaf("l11");
        Leaf l21 = new Leaf("l21");
        root.addNode(b1);
        root.addNode(b2);
        b1.addNode(l11);
        b2.addNode(l21);

        tree(root,0);
    }

    private static void tree(Node node,int dept) {
        for (int i=0;i<dept;i++) {
            System.out.print("|-");
        }
        node.print();
        if (node instanceof Branch) {
            Branch b = (Branch) node;
            for (Node n: b.getNodeList()) {
                tree(n,dept+1);
            }
        }
    }
}
