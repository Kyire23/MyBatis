package com.oumuanode.mybatis.test;

import com.oumuanode.mybatis.mapper.CarMapper2;
import com.oumuanode.mybatis.pojo.Car;
import com.oumuanode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectByMultiCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        List<Car> cars = mapper.selectByMultiCondition("比亚迪",30.00,"新能源");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪", 30.00, "新能源");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        List<Car> cars = mapper.selectByMultiConditionWithTrim("比亚迪", 30.00, "");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testUpdateWithSet(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        Car car = new Car(1L, "1010", "比亚迪", 30.00, "", null);
        int count = mapper.updateWithSet(car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        List<Car> cars = mapper.selectByChoose("丰田霸道", 20.0, "2000-10-10");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testDeleteBatchByForeachWithIn(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        int count = mapper.deleteBatchByForeachWithIn(new Long[]{2L, 3L, 4L});
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteBatchByForeachWithOr(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        int count = mapper.deleteBatchByForeachWithOr(new Long[]{5L, 6L, 7L});
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertBatchByForeach(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        Car car1 = new Car(null, "1001", "凯美瑞", 35.0, "2010-10-11", "燃油车");
        Car car2 = new Car(null, "1002", "比亚迪唐", 31.0, "2020-11-11", "新能源");
        Car car3 = new Car(null, "1003", "比亚迪宋", 32.0, "2020-10-11", "新能源");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int count = mapper.insertBatchByForeach(cars);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper2 mapper = sqlSession.getMapper(CarMapper2.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }


}
