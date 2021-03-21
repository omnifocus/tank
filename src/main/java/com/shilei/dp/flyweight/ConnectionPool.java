package com.shilei.dp.flyweight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {
    private LinkedList<Connection> connectionList = new LinkedList<>();

    public ConnectionPool() {
        connectionList.add(new Connection("mysql"));
        connectionList.add(new Connection("oracle"));
        connectionList.add(new Connection("sqlserver"));
        connectionList.add(new Connection("redis"));
    }

    public void addtoPool(Connection conn) {
        connectionList.addLast(conn);
    }

    public Connection getConn() {
        return connectionList.removeLast();
    }

    public LinkedList<Connection> getConnectionList() {
        return connectionList;
    }
}
