package com.imooc.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    static final String jdbc = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://106.14.31.199:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimeZoom=Asia/Shanghai&allowPublicKeyRetrieval=true";

    /**
     * 记载并注册jdbc驱动
     * 创建新的数据库连接
     * @return Connection 对象
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        1. 加载并注册jdbc驱动
        Class.forName(jdbc);
//        2.创建数据库连接
        Connection conn = DriverManager.getConnection(url, "root", "ldqdasN1126");
        return conn;
    }

    /**
     * 关闭连接，释放资源
     * @param conn Connection对象
     */
    public static void close(Connection conn){
        try {
            if (!conn.isClosed()) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
