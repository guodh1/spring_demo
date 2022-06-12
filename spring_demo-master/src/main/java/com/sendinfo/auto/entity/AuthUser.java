package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AuthUser implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String password;

    private Date loginDate;

    private Boolean isSuperuser;

    private String username;

    private String email;

    private Date dateJoined;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}