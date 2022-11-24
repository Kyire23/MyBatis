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
    // SqlSessionUtil工具类在进行第一次加载的时候，解析mybatis-config.xml文件，创建SqlSessionFactory对象。
    static {
        try {
            sqlSessionFactory  = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 全局的，服务器级别的，一个服务器当中定义一个即可。
    // 为什么把SqlSession对象放到ThreadLocal当中呢？为了保证一个线程对应一个SqlSession。
    private static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
    /**
     * 获取SqlSession对象
     * @return SqlSession 会话对象
     */
    //获取会话对象
    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession ==null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭会话，释放资源 同时与当前线程解绑
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession == null){
            sqlSession.close();
            // 注意移除SqlSession对象与当前线程的绑定关系。
            // 因为Tomcat服务器支持线程池。也就是说：用过的线程对象t1，可能下一次还会使用这个t1线程
            local.remove();
        }
    }
}
