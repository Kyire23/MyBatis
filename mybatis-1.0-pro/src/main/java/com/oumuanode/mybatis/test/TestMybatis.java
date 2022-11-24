package com.oumuanode.mybatis.test;

import com.oumuanode.mybatis.test.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;


public class TestMybatis {
    public static void main(String[] args) throws IOException {
        // 1. 获取 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 获取 SqlSessionFactory 对象
        // InputStream is = new FileInputStream("mybatis-config.xml");
        // InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml"); // Resources.getResourceAsStream 默认从类的根路径下查找资源
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is); // 一般情况下都是一个数据库对应一个SqLSessionFactory对象。


        // 3. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 执行 sql 语句
        int count = sqlSession.insert("insertCar");  // 返回值是影响数据库表当中的记录条数。
        System.out.println("插入了几条记录？：" + count);

        // 5. 提交（mybatis默认采用的事务管理器是JDBC，默认是不提交的，需要手动提交。）
        sqlSession.commit();

        // 6. 关闭资源（只关闭是不会提交的）
        sqlSession.close();
    }
}