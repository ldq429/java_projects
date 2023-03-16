package com.imooc.jdbc.sample;

import com.imooc.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class ConnectionTransactionSample {
    public void tc1(){
        Connection conn = null;
        try {
            long startTime = new Date().getTime();
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
//            3.创建prepareStatement

            String sql = "insert into employee(eno,ename,salary,dname)values(?,?,?,?)";
            for (int i = 1000; i < 2000; i++) {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, 3305);
                preparedStatement.setString(2, "员工" + i);
                preparedStatement.setDouble(3, 9000);
                preparedStatement.setString(4, "销售部");
                int rs = preparedStatement.executeUpdate();
            }
            conn.commit();
            long endTime = new Date().getTime();
            System.out.println("tc1运行时长为：" + (endTime-startTime));
//            4.结果集
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }  finally {
//            5.关闭连接
            DBUtils.close(conn);
        }
    }

    public void tc2(){
        Connection conn = null;
        try {
            long startTime = new Date().getTime();
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
//            3.创建prepareStatement
            String sql = "insert into employee(eno,ename,salary,dname)values(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for (int i = 3000; i < 4000; i++) {
                preparedStatement.setInt(1, 3305);
                preparedStatement.setString(2, "员工" + i);
                preparedStatement.setDouble(3, 9000);
                preparedStatement.setString(4, "销售部");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            conn.commit();
            long endTime = new Date().getTime();
            System.out.println("tc2运行时长为：" + (endTime-startTime));
//            4.结果集
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }  finally {
//            5.关闭连接
            DBUtils.close(conn);
        }
    }
    public static void main(String[] args) {
        ConnectionTransactionSample conn = new ConnectionTransactionSample();
        conn.tc1();
        conn.tc2();
    }

}
