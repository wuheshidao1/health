package com.jb.service;

import com.jb.pojo.User;

public interface UserService {
    public User findByUsername(String username);
}
