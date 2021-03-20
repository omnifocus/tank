package com.shilei.dp.filter;

import java.util.ArrayList;
import java.util.List;

public class Filter1 {

    public static void main(String[] args) {

        FilterChain chain = new FilterChain();
        chain.addFilter(new URLFilter()).addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter()).addFilter(new HTMLFilter());

        Request req = new Request("req:<abc:)www.yovya.com996");
        Response resp = new Response("resp:<abc:)www.yovya.com996");
        chain.doFilter(req,resp);
        System.out.println("结果：-----");
        System.out.println(req.reqStr);
        System.out.println(resp.respStr);
    }
}

class Message {
    String msg;

    public Message(String msg) {
        this.msg = msg;
    }
}

interface Filter {
    void doFilter(Request req,Response resp,FilterChain chain);
}


class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request req,Response resp,FilterChain chain) {
        req.reqStr = req.reqStr.replace("<", "[");
        System.out.println("HTMLFilter.doFilter.req执行");
        chain.doFilter(req,resp);
        resp.respStr = resp.respStr.replace("<", "[");
        System.out.println("HTMLFilter.doFilter.resp执行");
    }
}

class FaceFilter implements Filter {

    @Override
    public void doFilter(Request req,Response resp,FilterChain chain) {
        req.reqStr = req.reqStr.replace(":)", "^_^");
        System.out.println("FaceFilter.doFilter.req执行");
        chain.doFilter(req,resp);
        resp.respStr = resp.respStr.replace(":)", "^_^");
        System.out.println("FaceFilter.doFilter.resp执行");
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request req,Response resp,FilterChain chain) {
        req.reqStr = req.reqStr.replace("996", "965");
        System.out.println("SensitiveFilter.doFilter.req执行");
        chain.doFilter(req,resp);
        resp.respStr = resp.respStr.replace("996", "965");
        System.out.println("SensitiveFilter.doFilter.resp执行");

    }
}

class URLFilter implements Filter {

    @Override
    public void doFilter(Request req,Response resp,FilterChain chain) {
        System.out.println("URLFilter.doFilter.req执行");
        req.reqStr = req.reqStr.replace("www", "http://www");
        chain.doFilter(req,resp);
        resp.respStr = resp.respStr.replace("www", "http://www");
        System.out.println("URLFilter.doFilter.resp执行");

    }
}


class FilterChain {
    List<Filter> filterlist = new ArrayList<>();
    int step ;

    FilterChain addFilter(Filter filter) {
        filterlist.add(filter);
        return this;
    }

    public void doFilter(Request req,Response resp) {
         if (step < filterlist.size())
            filterlist.get(step++).doFilter(req,resp,this);
    }
}

class Request {
    String reqStr;

    public Request(String reqStr) {
        this.reqStr = reqStr;
    }
}

class Response {
    String respStr;

    public Response(String respStr) {
        this.respStr = respStr;
    }
}