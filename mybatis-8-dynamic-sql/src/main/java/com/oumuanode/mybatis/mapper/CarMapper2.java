package com.oumuanode.mybatis.mapper;

import com.oumuanode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 汽车表映射接口
 * @author oumuanode
 * @version 1.0
 * @since 1.0
 */
public interface CarMapper2 {
    /**
     * 多条件查询车辆信息
     * 条件包括：品牌（brand）、指导价格（guide_price）、汽车类型（car_type）
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand")String brand, @Param("guidePrice")Double guidePrice, @Param("carType")String carType);

    /**
     * 多条件查询车辆信息
     * 条件包括：品牌（brand）、指导价格（guide_price）、汽车类型（car_type）
     * 使用<where>标签实现
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand")String brand, @Param("guidePrice")Double guidePrice, @Param("carType")String carType);


    /**
     * 多条件查询车辆信息
     * 条件包括：品牌（brand）、指导价格（guide_price）、汽车类型（car_type）
     * 使用<trim>标签实现
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand")String brand, @Param("guidePrice")Double guidePrice, @Param("carType")String carType);

    /**
     * 使用<set>标签更新车辆信息
     * @param car
     * @return
     */
    int updateWithSet(Car car);


    /**
     * 使用<choose>、<when>、<otherwise>标签查询车辆信息
     * 先根据品牌查询，如果没有提供品牌，再根据指导价格查询，如果没有提供指导价格，就根据生产日期查询。
     * @param brand
     * @param guidePrice
     * @param produceTime
     * @return
     */
    List<Car> selectByChoose(@Param("brand")String brand, @Param("guidePrice")Double guidePrice, @Param("produceTime")String produceTime);


    /**
     * 根据id批量删除车辆信息，用in
     * 使用<foreach>标签
     * @param ids
     * @return
     */
    int deleteBatchByForeachWithIn(@Param("ids")Long[] ids);

    /**
     * 根据id批量删除车辆信息，用or
     * 使用<foreach>标签
     * @param ids
     * @return
     */
    int deleteBatchByForeachWithOr(@Param("ids")Long[] ids);

    /**
     * 批量添加车辆信息
     * 使用<foreach>标签
     * @param cars
     * @return
     */
    int insertBatchByForeach(@Param("cars")List<Car> cars);

    /**
     * 查询所有汽车信息
     * @return
     */
    List<Car> selectAll();


}
