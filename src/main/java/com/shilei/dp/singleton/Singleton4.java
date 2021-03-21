package com.shilei.dp.singleton;

public enum Singleton4 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            new Thread(()->{
                System.out.println(Singleton4.INSTANCE.hashCode());
            }).start();
        }
    }
}
