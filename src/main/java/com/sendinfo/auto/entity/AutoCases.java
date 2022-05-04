package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AutoCases implements Serializable {
    private Integer id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private Date runTime;

    private Integer paramsId;

    private String param;

    private static final long serialVersionUID = 1L;
}