package com.imooc.jdbc.sample;

import com.imooc.jdbc.common.DBUtils;

import java.sql.*;
import java.util.Scanner;

public class ConnectionQuerySample {
    public static void main(String[] args) {
        System.out.println("请输入部门编号");
        Scanner scanner = new Scanner(System.in);
        int eno = scanner.nextInt();
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
//            3.创建prepareStatement
            String sql = "select * from employee where eno = ? order by id desc limit ?, 5";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, eno);
            preparedStatement.setInt(2, 0);
//            4.结果集
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("id=" + rs.getInt("id") + "," + "ename=" + rs.getString("ename") + "," + "eno=" + rs.getInt("eno"));
            }
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
