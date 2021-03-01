package com.keqi.formcookiesession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoginUserBO extends User {

    private static final long serialVersionUID = -8062937254808115282L;

    public LoginUserBO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
