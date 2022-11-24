package com.oumuanode.mybatis.mapper;

import com.oumuanode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    List<Car> selectByBrandLike(String str);

    /**
     * 获取自动生成的主键
     * @param car
     */
    int insertGetGeneratedKeys(Car car);







}
