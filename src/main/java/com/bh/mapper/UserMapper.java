package com.bh.mapper;

import com.bh.pojo.User;
import com.bh.pojo.UserQueryVo;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    //根据用户id查询用户信息
    public User findUserById(int id) throws Exception;
    //查询用户列表
    public List<User> findUserByUsername(String username) throws Exception;
    //添加用户信息
    public void insertUser(User user)throws Exception;
//    public List<User> findUserByUser(User user);
    public User findUserByUser(User user);
    public List<UserQueryVo> findUserList(UserQueryVo userQueryVo);
    public int findUserCount(User user);
    public List<User> findUserByHashMap(HashMap hashMap);
    List<User> findUserInList(UserQueryVo userQueryVo);
    List<User> findUserByArray(Object[] userlist);
}
