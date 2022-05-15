package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AutoChannel implements Serializable {

    // 主键自增
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @Size(min = 1,max = 100,message = "用户名长度在1-100之间")
    @NotEmpty(message = "用户名不能为空")
    private String name;

    // 添加数据时自动插入，见config/DateHandler类
    @TableField(fill = FieldFill.INSERT)
    private String author;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editor;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}