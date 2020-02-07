package com.homelib.model;

import org.springframework.security.core.GrantedAuthority;

public enum Genre implements GrantedAuthority {
    DRAMA,ROMANCE;


    @Override
    public String getAuthority() {
        return name();
    }
}
