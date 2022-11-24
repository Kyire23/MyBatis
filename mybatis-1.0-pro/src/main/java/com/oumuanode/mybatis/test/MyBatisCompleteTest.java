package com.oumuanode.mybatis.test;

import com.oumuanode.mybatis.test.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


/**
 * 完整版MyBatis
 */

public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
            //处理业务
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            //回滚事务
            if (sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            //关闭会话(释放资源)
            if (sqlSession != null){
                sqlSession.close();
            }
        }

    }
}
