package com.jb.controller;

import com.jb.constant.MessageConstant;
import com.jb.entity.Result;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    //获取当前登录（认证）用户的用户名
    @RequestMapping("/getLoginUsername")
    public Result getLoginUsername(){
        try{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            String password = user.getPassword();
            Collection<GrantedAuthority> authorities = user.getAuthorities();
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,username);
        }catch (Exception e){
            return new Result(false, MessageConstant.GET_USERNAME_FAIL);
        }
    }

/*    @RequestMapping("/add")
    public Result add(@RequestBody User user){

    }*/
}
