package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AuthUser implements Serializable {
    private Integer id;

    private String password;

    private Date lastLogin;

    private Boolean isSuperuser;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean isStaff;

    private Boolean isActive;

    private Date dateJoined;

    private static final long serialVersionUID = 1L;
}