package com.imooc.mybatis;

import com.imooc.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class MyBatisTestor {
    @Test
    public void testSqlSessionFactory() throws IOException {
        // 利用Reader加载calsspath下的mybatis-confog.xml核心配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        // 初始化SqlSessionFactory对象，同时解析mybatis-config.xml文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        System.out.println("SqlSessionFactory 加载成功");
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
    }

    @Test
    public void testMyBatisUtils(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

}
