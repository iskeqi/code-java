package com.keqi.springsecurityjwt.sys.service;

import com.keqi.springsecurityjwt.sys.pojo.LoginUserBO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new LoginUserBO("admin",
                "$2a$10$3iggZvKw6GyuGYmZZFAtpeK6AuR2Z3Ku9KuA.GWoYE.fcZuOAzFS2",
                Collections.emptyList());

    }
}
