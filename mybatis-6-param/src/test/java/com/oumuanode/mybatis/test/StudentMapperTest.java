package com.oumuanode.mybatis.test;

import com.oumuanode.mybatis.mapper.StudentMapper;
import com.oumuanode.mybatis.pojo.Student;
import com.oumuanode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperTest {

    @Test
    public void testSelectByMultiParam(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByMultiParam("张三", '男');
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }


    /**
     * 这⾥需要注意的是：#{} ⾥面写的是属性名字。
     * 这个属性名其本质上是：set/get方法名去掉set/get之后的名字。
     */
    @Test
    public void testInsertByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(null,"马云",58,1.72,'男',new Date());
        int count = mapper.insertByPOJO(student);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 这种方式是手动封装Map集合，将每个条件以key和value的形式存放到集合中。
     * 然后在使用的时候通过#{map集合的key}来取值。
     */
    @Test
   public void testSelectByParaMap(){
       SqlSession sqlSession = SqlSessionUtil.openSession();
       StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
       Map<String,Object> map = new HashMap<>();
       map.put("nameKey","张三");
       map.put("ageKey","18");
       List<Student> studentList = mapper.selectByParaMap(map);
       studentList.forEach(student -> System.out.println(student));
       sqlSession.close();
   }


    @Test
    public void testSelectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.selectBySex('男');
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testSelectByBirth(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        try {
            List<Student> students = mapper.selectByBirth(new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-16"));
            students.forEach(student -> System.out.println(student));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1L);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.selectByName("张三");
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

}
