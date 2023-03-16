package com.imooc.jdbc.sample;

import com.imooc.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionInsertSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入部门编号");
        int eno = scanner.nextInt();
        System.out.println("请输入部门名称");
        scanner = new Scanner(System.in);
        String dname = scanner.nextLine();
        System.out.println("请输入员工姓名");
        scanner = new Scanner(System.in);
        String ename = scanner.nextLine();
        System.out.println("请输入薪水");
        scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
//            3.创建prepareStatement
            String sql = "insert into employee(eno,ename,salary,dname)values(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, eno);
            preparedStatement.setString(2, ename);
            preparedStatement.setDouble(3, salary);
            preparedStatement.setString(4, dname);
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
