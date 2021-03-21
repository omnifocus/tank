package com.shilei.dp.flyweight;

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        Connection conn = pool.getConn();
        System.out.println(pool.getConnectionList());
        System.out.println(conn);
        System.out.println("dosomething...");
        pool.addtoPool(conn);
        System.out.println(pool.getConnectionList());

    }
}
