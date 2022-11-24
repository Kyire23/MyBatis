package com.oumuanode.mybatis.test;

import com.oumuanode.mybatis.mapper.CarMapper3;
import com.oumuanode.mybatis.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class CacheTest {
    @Test
    public void testSelectById() throws IOException {
        // 不能使用工具类
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CarMapper3 mapper1 = sqlSession1.getMapper(CarMapper3.class);
        CarMapper3 mapper2 = sqlSession1.getMapper(CarMapper3.class);
        Car car1 = mapper1.selectById(1L);
        System.out.println(car1);
        Car car2 = mapper2.selectById(1L);
        System.out.println(car2);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper3 mapper3 = sqlSession2.getMapper(CarMapper3.class);
        CarMapper3 mapper4 = sqlSession2.getMapper(CarMapper3.class);
        Car car3 = mapper3.selectById(12L);
        System.out.println(car3);
        Car car4 = mapper4.selectById(12L);
        System.out.println(car4);

        sqlSession1.close();
        sqlSession2.close();
    }
}
