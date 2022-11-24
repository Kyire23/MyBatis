package com.oumuanode.test;

import com.oumuanode.mybatis.mapper.CarMapper;
import com.oumuanode.mybatis.pojo.Car;
import com.oumuanode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CarMapperTest {


    @Test
    public void testSelectTotal(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long count = mapper.selectTotal();
        System.out.println("总记录条数为：" + count);
        sqlSession.close();
    }

    @Test
    public void testSelectAllByMapUnderscoreToCamelCase(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testselectAllByResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String,Object>> maps = mapper.selectAllRetMap();
        System.out.println(maps);
        sqlSession.close();
    }

    @Test
    public void testselectAllRetListMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String,Object>> map = mapper.selectAllRetListMap();
        System.out.println(map);
        sqlSession.close();
    }



    @Test
    public void testSelectByIdRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> car = mapper.selectByIdRetMap(1L);
        System.out.println(car);
        sqlSession.close();
    }



    @Test
    public void selectByIdToListTest(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = mapper.selectByIdToList(1L);
        System.out.println(carList);
        sqlSession.close();

    }




    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByID(1L);
        System.out.println(car);
        sqlSession.close();
    }


}
