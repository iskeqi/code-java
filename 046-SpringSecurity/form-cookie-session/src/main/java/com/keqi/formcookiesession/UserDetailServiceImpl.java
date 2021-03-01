package com.keqi.formcookiesession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名从数据库中查找到对应的用户信息即可

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("test"));
        authorities.add(new SimpleGrantedAuthority("ROLE_super_admin"));


        return new LoginUserBO("admin", "$2a$10$ckBawa7Gi4ogDYar0NFjbOTvbZBbl9eNi.vwQR2c5VXocFLkFgdRq", authorities);
    }
}
