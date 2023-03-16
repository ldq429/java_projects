package com.imooc.mybatis.utils;

import jdk.jshell.spi.ExecutionControl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {
    // static静态成员创建全局唯一的sqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;
    // static静态代码块初始化sqlSessionFactory
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            // 抛出类加载异常，通知调用者
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 创建SqlSession
     * @return
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭sqlSession
     * @param sqlSession
     */
    public static void closeSession(SqlSession sqlSession){
        if(sqlSession != null) sqlSession.close();
    }

}
