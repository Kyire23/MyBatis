package com.oumuanode.mybatis.mapper;

import com.oumuanode.mybatis.pojo.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /**
     * 多参数查询，根据name和sex查询学生信息
     * @return
     */
    List<Student> selectByMultiParam(String name, Character sex);

    /**
     * 插入学生信息
     * @param student
     * @return
     */
    int insertByPOJO(Student student);


    /**
     * 根据学生名查询学生信息
     * @param name
     * @return
     */
    List<Student> selectByName(String name);

    /**
     * 根据id查询学生信息
     * @param id
     * @return
     */
    Student selectById(Long id);

    /**
     * 根据生日birth查找学生信息
     * @param birth
     * @return
     */
    List<Student> selectByBirth(Date birth);

    /**
     * 根据性别sex查询学生信息
     * @param sex
     * @return
     */
    List<Student> selectBySex(Character sex);

    /**
     * 利用Map根据name和age查询学生信息
     * @param paramMap
     * @return
     */
    List<Student> selectByParaMap(Map<String, Object> paramMap);

}
