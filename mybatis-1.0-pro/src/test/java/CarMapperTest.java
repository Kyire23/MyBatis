import com.oumuanode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CarMapperTest {

    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testInsertCar(){
        //编写mybatis程序
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
