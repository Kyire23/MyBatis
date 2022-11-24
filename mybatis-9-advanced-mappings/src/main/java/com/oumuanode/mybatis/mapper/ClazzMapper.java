package com.oumuanode.mybatis.mapper;

import com.oumuanode.mybatis.pojo.Clazz;
/**
 * 班级表映射接口
 * @author ShiningSong
 * @version 1.0
 * @since 1.0
 */

public interface ClazzMapper {


        /**
         * 根据cid查询班级信息
         * @param cid
         * @return
         */
        Clazz selectByCid(Long cid);

        /**
         * 根据cid查询班级信息
         * 同时也要查询班级的学生信息
         * @param cid
         * @return
         */
        Clazz selectClazzAndStudentsByCid(Long cid);

}
