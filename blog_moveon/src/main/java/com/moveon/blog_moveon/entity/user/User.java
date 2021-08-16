package com.moveon.blog_moveon.entity.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String uuid;
    private String username;
    private String password;
    private Integer userNo;
    private String userType;
    private String registerTime;

}
