package com.oumuanode.mybatis.mapper;

import com.oumuanode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    /**
     * 汽车表t_car映射接口
     * @author oumuanode
     * @version 1.0
     * @since 1.0
     */
    Car selectByID(Long id);

    /**
     * 根据id查询车辆信息放入List中
     * @param id
     * @return
     */
    List<Car> selectByIdToList(Long id);
    /**
     * 将查询结果返回单个POJO类
     * 如果查询结果超过一个会报异常
     * @return
     */
    Car selectAllToPOJO();

    /**
     * 通过id查询一条记录，返回Map集合
     * @param id
     * @return
     */
    Map<String, Object> selectByIdRetMap(Long id);

    /**
     * 查询所有车辆信息，返回一个List集合，List集合中存储的是保存车辆信息的Map集合
     * @return
     */
    List<Map<String, Object>> selectAllRetListMap();



    /**
     * 查询所有车辆信息，返回一个Map集合，
     * Map集合中存储的是保存车辆信息的Map集合，
     * 大Map的key是小map的id，使用@MapKey注解实现
     * @return
     */
    @MapKey("id")
    Map<Long, Map<String, Object>> selectAllRetMap();

    /**
     * 查询所有Car，使用resultMap进行结果映射
     * @return
     */
    List<Car> selectAllByResultMap();

    /**
     * 查询所有车辆信息，启用驼峰命名自动映射
     * @return
     */
    List<Car> selectAllByMapUnderscoreToCamelCase();


    /**
     * 获取总记录条数
     * @return
     */
    Long selectTotal();

}
