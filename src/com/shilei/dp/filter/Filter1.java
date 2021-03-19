package com.shilei.dp.filter;

public class Filter1 {

    public static void main(String[] args) {
        Message msg = new Message("<abc:)");
        HTMLFilter filter1 = new HTMLFilter();
        FaceFilter filter2 = new FaceFilter();
        filter1.doFilter(msg);
        filter2.doFilter(msg);
        System.out.println(msg.msg);
    }
}
class Message {
    String msg;

    public Message(String msg) {
        this.msg = msg;
    }
}

interface Filter {
    void doFilter(Message msg);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Message msg) {
        msg.msg = msg.msg.replace("<","[");
    }
}
class FaceFilter implements Filter {

    @Override
    public void doFilter(Message msg) {
        msg.msg = msg.msg.replace(":)","^_^");
    }
}
