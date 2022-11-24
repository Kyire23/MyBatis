package com.oumuanode.mybatis.test;

import com.oumuanode.mybatis.mapper.ClazzMapper;
import com.oumuanode.mybatis.mapper.StudentMapper;
import com.oumuanode.mybatis.pojo.Clazz;
import com.oumuanode.mybatis.pojo.Student;
import com.oumuanode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AdvancedMappingTest {
//    @Test
//    public void testSelectBySid(){
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = mapper.selectBySid(1L);
//        System.out.println(student);
//        sqlSession.close();
//    }
//
//    @Test
//    public void testSelectBySid2(){
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = mapper.selectBySid(2L);
//        //        System.out.println(student);
//        // 只获取学生姓名
//        System.out.println("学生姓名：" + student.getSname());
//        sqlSession.close();
//    }

//    @Test
//    public void testSelectBySid3(){
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = mapper.selectBySid(2L);
//        //        System.out.println(student);
//        // 只获取学生姓名
//        System.out.println("学生姓名：" + student.getSname());
//        // 到这里想要获取班级名字
//        System.out.println("该学生的班级名称：" + student.getClazz().getCname());
//        sqlSession.close();
//    }


    @Test
    public void testSelectClazzAndStudentsByCid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectClazzAndStudentsByCid(1001L);
        System.out.println(clazz);
        sqlSession.close();
    }


}
