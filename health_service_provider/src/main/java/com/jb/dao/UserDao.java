package com.jb.dao;

import com.jb.pojo.User;

public interface UserDao {
    public User findByUsername(String username);
}
