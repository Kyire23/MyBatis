package com.oumuanode.mybatis.mapper;

import com.oumuanode.mybatis.pojo.Car;

public interface CarMapper3 {
    /**
     * 根据id 获取Car 信息
     * @param id
     * @return
     */
    Car selectById(Long id);

}
