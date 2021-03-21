package com.shilei.dp.listener;

import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) {
        Child child = new Child("shilei");
        MyActionListener l1 = new MyActionListener1();
        MyActionListener l2 = new MyActionListener2();
        child.addListener(l1);
        child.addListener(l2);
        child.wakeup();

    }

}
