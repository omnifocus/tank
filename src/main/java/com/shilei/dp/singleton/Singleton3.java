package com.shilei.dp.singleton;

public class Singleton3 {
    private Singleton3() {}
    private static class SingletonInner {
       private static final Singleton3 SINGLETON_3 = new Singleton3();
    }
    public static Singleton3 getInstance() {
        return SingletonInner.SINGLETON_3;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            new Thread(()->{
                System.out.println(Singleton3.getInstance().hashCode());
            }).start();
        }
    }
}
