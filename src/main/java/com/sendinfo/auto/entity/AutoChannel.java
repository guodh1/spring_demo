package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sendinfo.auto.common.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AutoChannel extends BaseModel {

    @Size(min = 1,max = 100,message = "用户名长度在1-100之间")
    @NotEmpty(message = "用户名不能为空")
    private String name;

    private static final long serialVersionUID = 1L;
}