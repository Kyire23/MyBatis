package com.oumuanode.mybatis.mapper;

import com.oumuanode.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {


//    /**
//     * 通过sid查询学生信息
//     * @param sid
//     * @return
//     */
//    Student selectBySid(Long sid);

    /**
     * 根据cid查询学生信息返回List集合
     * @param cid
     * @return
     */
    List<Student> selectByCid(Long cid);

}
