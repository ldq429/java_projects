package com.imooc.mybatis;

import com.imooc.mybatis.dto.GoodsDTO;
import com.imooc.mybatis.entity.Goods;
import com.imooc.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testMyBatisUtils() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void queryGoods() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<Goods> list = sqlSession.selectList("goods.queryAll");
            list.stream().forEach(good -> {
                System.out.println(good.getTitle());
            });
            System.out.println(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void queryGoodsByID() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.queryGoodsById", 1602);
            System.out.println(goods.getTitle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void queryByPriceRange() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map params = new HashMap<>();
            params.put("min", 100);
            params.put("max", 500);
            params.put("limit", 10);
            List<Goods> list = sqlSession.selectList("goods.queryByPriceRange", params);
            list.stream().forEach(good -> System.out.println(good.getCurrentPrice()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void queryCategoryName() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<java.util.Map> list = sqlSession.selectList("goods.queryCategoryName");
            list.stream().forEach(good -> System.out.println(good));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }


    @Test
    public void queryGoodsDTO() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<GoodsDTO> list = sqlSession.selectList("goods.queryGoodsDTO");
            list.stream().forEach(good -> System.out.println(good));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Goods goods = new Goods();
            goods.setTitle("测试商品");
            goods.setSubTitle("测试子标题");
            goods.setOriginalCost(200f);
            goods.setCurrentPrice(100f);
            goods.setDiscount(0.5f);
            goods.setIsFreeDelivery(1);
            goods.setCategoryId(43);
            int res = sqlSession.insert("goods.insert", goods);
            sqlSession.commit();
            System.out.println(goods.getGoodsId());
        } catch (Exception e) {
            if (sqlSession != null) sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.queryGoodsById", 739);
            goods.setTitle("更新测试商品名称");
            int res = sqlSession.update("goods.update", goods);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            int res = sqlSession.delete("goods.delete", 739);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testDynamic() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map params = new HashMap<>();
//            params.put("currentPrice", 10f);
            params.put("categoryId", 44);
            List<Goods> res = sqlSession.selectList("goods.dynamic", params);
            System.out.println(res);
            res.stream().forEach(g -> System.out.println(g.getTitle()));
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testOneToMany() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<Goods> res = sqlSession.selectList("goods.selectOneTOMany", 1694);
            System.out.println(res);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }
}
