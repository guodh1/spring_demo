package com.sendinfo.auto.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class AutoEnvs implements Serializable {
    private Integer id;

    private String name;

    private String url;

    private Boolean type;

    private static final long serialVersionUID = 1L;
}