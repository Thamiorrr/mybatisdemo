package com.bh.pojo;

import java.util.Date;

/**
 * @author Hasee
 * @Data 2021/3/10 10:35
 */
public class Person {
    private String id;
    private String username;  // 用户名
    private String sex;       // 性别
    private Date birthday;    // 出生日期
    private String address;   // 住址

    public Person() {
    }

    public Person(String id, String username, String sex, Date birthday, String address) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}