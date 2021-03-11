package com.bh;

import com.bh.pojo.User;
import com.bh.mapper.UserMapper;
import com.bh.pojo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author Hasee
 * @Data 2021/3/10 15:01
 */
public class MapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws IOException {
        //配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用SQLSessionFactory创建sessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public  void testFindUserById() throws Exception {
        //获取session
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用代理对象方法
        User user = userMapper.findUserById(1);
        System.out.println(user.toString());
        session.close();
    }
    @Test
    public void testFindUserByUsername() throws Exception {
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByUsername("张");
        System.out.println(list.size());
    }
    @Test
    public void testInsertUser() throws Exception {
        //获取session
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //要添加的数据
        User user = new User();
        user.setUsername("张六");
        user.setSex("男");
        user.setAddress("北京市");
        //通过mapper接口添加用户
        userMapper.insertUser(user);
        //提交
        session.commit();
        //关闭session
        session.close();
    }
    @Test
    public void testFindUserByUser()throws Exception{
        //获取session
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //要添加的数据
        User user = new User();
        user.setId(1);
        user.setUsername("王五");
//        List<User> list = userMapper.findUserByUser(user);
        User u = userMapper.findUserByUser(user);
        session.close();
        System.out.println(u.toString());
        //1
//        System.out.println(list.size());
    }
    @Test public void testFindUserList(){
        //创建对象--获取 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建 UserMapper 对象，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setSex("女");
        user.setUsername("周涛");

        //传入多个 id
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(29);
        ids.add(31);

        //将 ids 通过 userQueryVo 传入 statement 中
        userQueryVo.setIds(ids);
        userQueryVo.setUser(user);

        //调用方法完成多条件查询
        List<UserQueryVo> userList = userMapper.findUserList(userQueryVo);

        System.out.println(userList.size());
        //释放资源
        sqlSession.close();
    }
    @Test
    public void testFindUserCount(){
        //创建对象--获取 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建 UserMapper 对象，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("张张");
        int count = userMapper.findUserCount(user);
        System.out.println(count);
        sqlSession.close();
    }
    @Test
    public void testFindUserByHashMap(){
        //创建对象--获取 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建 UserMapper 对象，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username","王五");
        List<User> list = userMapper.findUserByHashMap(map);
        System.out.println(list.size());
        sqlSession.close();
    }
    @Test
    public void testfindUserInList(){
        //创建对象--获取 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建 UserMapper 对象，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);//查询id为1的用户
        ids.add(10); //查询id为10的用
        userQueryVo.setIds(ids);
        List<User> list = userMapper.findUserInList(userQueryVo);
        System.out.println(list);
    }
    @Test
    public void testFindByArray(){
        //创建对象--获取 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建 UserMapper 对象，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
        Object[] ids = new Object[2];
        User user = new User();
        user.setId(1);
        ids[0] = user;
        System.out.println(user);
//        user = new User();
        user.setId(10);
        System.out.println(user);

        ids[1] = user;
        List<User> list = userMapper.findUserByArray(ids);
        System.out.println(list);
        System.out.println(ids[0]);
        System.out.println(ids[1]);

        sqlSession.close();
    }
}

