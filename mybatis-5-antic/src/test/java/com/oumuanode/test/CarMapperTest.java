package com.oumuanode.test;

import com.oumuanode.mapper.CarMapper;
import com.oumuanode.pojo.Car;
import com.oumuanode.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //面向接口获取接口代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"8848","美凯龙",3.0,"2002-2-10","燃油车");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();
    }
    @Test
    public void testDeleteById(){
        SqlSession sqlSession =SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        int count = carMapper.deleteById(884L);
        System.out.println(count);
        sqlSession.commit();


    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(155L,"8848","美凯龙",3.0,"2002-2-10","燃油车");
        mapper.update(car);
        sqlSession.commit();
    }
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(155L);
        System.out.println(car);
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(cars));
    }
}
