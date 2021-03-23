package com.shilei.dp.bridge;

public class Main {
    public static void main(String[] args) {
        GiftImpl impl = new Book();
        //温柔的书
        Gift warmGift = new WarmGift(impl);
        //冷酷的书
        Gift coldGift = new ColdGift(impl);
    }
}
