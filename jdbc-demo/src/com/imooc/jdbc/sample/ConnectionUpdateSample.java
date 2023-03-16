package com.imooc.jdbc.sample;

import com.imooc.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionUpdateSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入id");
        int id = scanner.nextInt();

        System.out.println("请输入新的姓名");
        scanner = new Scanner(System.in);
        String ename = scanner.nextLine();

        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
//            3.创建prepareStatement
            String sql = "update employee set ename = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ename);
            preparedStatement.setDouble(2, id);
//            4.结果集
            int rs = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            5.关闭连接
            DBUtils.close(conn);
        }
    }

}
