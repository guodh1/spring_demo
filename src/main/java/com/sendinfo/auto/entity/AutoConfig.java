package com.sendinfo.auto.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class AutoConfig implements Serializable {
    private Integer id;

    private String name;

    private Integer envId;

    private String privateKey;

    private String publicKey;

    private static final long serialVersionUID = 1L;
}