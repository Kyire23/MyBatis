package com.oumuanode.test;

import com.oumuanode.mybatis.mapper.CarMapper;
import com.oumuanode.mybatis.pojo.Car;
import com.oumuanode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByBrandLike("比亚迪");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testInsertGetGeneratedKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "8888", "劳斯莱斯幻影", 920.0, "2018-09-10", "燃油车");
        int count =  mapper.insertGetGeneratedKeys(car);
        System.out.println("插入了几条数据：" + count);
        sqlSession.commit();
        System.out.println("自动生成的CarId为：" + car.getId());
        sqlSession.close();
    }

}
