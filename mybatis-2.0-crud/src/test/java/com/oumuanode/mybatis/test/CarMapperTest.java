package com.oumuanode.mybatis.test;

import com.oumuanode.mybatis.pojo.Car;
import com.oumuanode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object>  cars = sqlSession.selectList("selectAll");
        cars.forEach(car -> System.out.println(car));

        sqlSession.close();
    }


    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectById",1);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(4L,"9999","保时捷",90.0,"2002-11-6","燃油车");
        int count = sqlSession.update("updateById",car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteById", 4);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null,"3333","比亚迪",30.0,"2021-11-10","新能源");
        int count = sqlSession.insert("insertCar",car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Map<String,Object> map = new HashMap<>();
        map.put("k1","1111");
        map.put("k2","五菱宏光");
        map.put("k3",10.0);
        map.put("k4","2022-11-10");
        map.put("k5","新能源");

        int count = sqlSession.insert("insertCar",map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }
}
