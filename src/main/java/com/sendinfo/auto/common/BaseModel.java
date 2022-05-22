package com.sendinfo.auto.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseModel implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    // 添加数据时自动插入，见config/DateHandler类
    @TableField(fill = FieldFill.INSERT)
    private String author;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editor;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
