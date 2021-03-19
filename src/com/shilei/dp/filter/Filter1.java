package com.shilei.dp.filter;

import java.util.ArrayList;
import java.util.List;

public class Filter1 {

    public static void main(String[] args) {
        Message msg = new Message("<abc:)");
        HTMLFilter filter1 = new HTMLFilter();
        FaceFilter filter2 = new FaceFilter();
        FilterChain chain = new FilterChain();
        chain.addFilter(filter1).addFilter(filter2);
        chain.doFilter(msg);
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

class FilterChain {
    List<Filter> filterlist = new ArrayList<>();
    FilterChain addFilter(Filter filter) {
        filterlist.add(filter);
        return this;
    }
    void doFilter(Message msg) {
        for (Filter filter : filterlist) {
            filter.doFilter(msg);
        }
    }
}