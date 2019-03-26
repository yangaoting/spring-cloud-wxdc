package com.example.user.enums;

import lombok.Getter;

@Getter
public enum  RoleEnum {
    BUYER(1,"买家"),
    SELLER(2,"卖家")
    ;

    private Integer code;
    private String rolename;

    RoleEnum(Integer code,String rolename){
        this.code = code;
        this.rolename = rolename;
    }
}
