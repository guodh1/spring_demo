package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.sendinfo.auto.common.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@TableName("auto_envs")
public class AutoEnvs extends BaseModel {

    @Size(min=1, max=100, message = "名称长度在1-100之间")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotEmpty(message = "url不能为空")
    private String url;

    private int type;

    private static final long serialVersionUID = 1L;
}