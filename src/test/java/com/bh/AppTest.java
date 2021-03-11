package com.bh; import static org.junit.Assert.assertTrue;

import com.bh.pojo.Person;
import com.bh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before; import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppTest {     /**      * Rigorous Test :-)      */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    //会话工厂
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void createSqlSessionFactory() throws IOException {

        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //根据id查询用户信息
    @Test
    public void testFindUserById() {
        //数据库连接对象
        SqlSession sqlSession = null;
        try {
            //数据库对象实例化
            sqlSession = sqlSessionFactory.openSession();
            //查询单个记录
            User user = sqlSession.selectOne("UserTest.findUserById", 1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void testInsert() {
        //数据库 查询对象
        SqlSession sqlSession = null;
        //对象实例化
        sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("李华");
        user.setAddress("高新");
        user.setSex("女");
        sqlSession.insert("UserTest.insertUser",user);
        //提交事务
        sqlSession.commit();
        if(sqlSession != null){
            sqlSession.close();
        }
        System.out.println(user.getId());
    }
    @Test
    public void testInsertWithUuid() {
        //数据库 查询对象
        SqlSession sqlSession = null;
        //对象实例化
        sqlSession = sqlSessionFactory.openSession();
        Person person = new Person();
        person.setUsername("李华");
        person.setAddress("高新");
        person.setSex("女");
        sqlSession.insert("PersonTest.insertPerson",person);
        //提交事务
        sqlSession.commit();
        if(sqlSession != null){
            sqlSession.close();
        }
        System.out.println(person.getId());
    }
    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = null;
        //实例化
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("UserTest.deleteUserById",33);
        sqlSession.commit();
        if(sqlSession != null){
            sqlSession.close();
        }
        Properties properties = new Properties();
    }
}