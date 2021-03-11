package com.bh.pojo;

import java.util.List;

/**
 * @author Hasee
 * @Data 2021/3/10 17:58
 */
public class UserQueryVo {     //传入多个id
    private List<Integer> ids;
    private User user;

    //查询条件--包装所有的查询条件
//    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public UserCustom getUserCustom() {
//        return userCustom;
//    }

//    public void setUserCustom(UserCustom userCustom) {
//        this.userCustom = userCustom;
//    }
}