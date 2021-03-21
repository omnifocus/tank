package com.shilei.dp.listener;

public class MyActionListener2 implements MyActionListener {
    @Override
    public void dosomething(MyEvent e) {
        System.out.println("listener2 begin...listening:"+e.getSource());
    }
}
