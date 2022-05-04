package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AutoParams implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String params;

    private static final long serialVersionUID = 1L;
}