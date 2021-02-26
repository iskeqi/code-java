package com.keqi.springsecurityjwt.sys.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoginUserBO extends User {

    private Long id;

    private String devType;

    private static final long serialVersionUID = 1197165893979800611L;

    public LoginUserBO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
