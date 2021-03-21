package com.shilei.dp.listener;

public class MyEvent<T> {
    private long curmills;
    private String loc;
    private T source;

    public MyEvent(long curmills, String loc, T source) {
        this.curmills = curmills;
        this.loc = loc;
        this.source = source;
    }

    public T getSource() {
        return source;
    }
}
