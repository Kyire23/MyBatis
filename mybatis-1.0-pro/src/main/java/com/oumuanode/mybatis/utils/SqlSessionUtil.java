package com.oumuanode.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    //工具类构造方法私有化 防止new 对象 且 所有方法都是静态 方便调用
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    //类加载时执行
    static {
        try {
            sqlSessionFactory  = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static SqlSession openSession(){
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        return sqlSession;
//    }

    //获取会话对象
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
