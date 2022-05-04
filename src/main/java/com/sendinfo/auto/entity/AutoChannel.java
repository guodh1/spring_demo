package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AutoChannel implements Serializable {

    // 主键自增
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    // 添加数据时自动插入，见config/DateHandler类
    @TableField(fill = FieldFill.INSERT)
    private String author;

    @TableField(fill = FieldFill.INSERT)
    private String editor;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}