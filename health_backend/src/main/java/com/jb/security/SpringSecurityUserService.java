package com.jb.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jb.pojo.Permission;
import com.jb.pojo.Role;
import com.jb.pojo.User;
import com.jb.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 如果我们要从数据库动态查询用户信息，就必须按照spring security框架的要求提供一个实现UserDetailsService接口的实现类，并按照框架的要求进行配置即可。
 */
@Component
public class SpringSecurityUserService implements UserDetailsService {
    //查找服务，实现查询数据库
    @Reference
    private UserService userService;

    //根据用户名查询数据库中用户信息
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用用户服务（底层基于Dubbo实现远程调用）获取用户信息
        User user = userService.findByUsername(username);
        if(user == null){
            return null;
        }

        //用于封装当前用户的角色和权限
        List<GrantedAuthority> list = new ArrayList<>();

        //查询当前用户对应的角色和权限
        Set<Role> roles = user.getRoles();
        if(roles != null && roles.size() > 0){
            for (Role role : roles) {
                String keyword = role.getKeyword();//角色关键字，是角色的标识
                //为当前用户授予角色
                list.add(new SimpleGrantedAuthority(keyword));
                //遍历当前角色对应的权限
                for (Permission permission : role.getPermissions()) {
                    String permissionKeyword = permission.getKeyword();//权限关键字
                    //为当前用户授权
                    list.add(new SimpleGrantedAuthority(permissionKeyword));
                }
            }
        }
        //返回数据库中查找到的密码password，和表单中的密码进行比较
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),list);
    }

}
