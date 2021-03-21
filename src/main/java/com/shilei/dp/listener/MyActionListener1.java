package com.shilei.dp.listener;

public class MyActionListener1 implements MyActionListener {
    @Override
    public void dosomething(MyEvent e) {
        System.out.println("listener1 begin...listening:"+e.getSource());
    }
}
