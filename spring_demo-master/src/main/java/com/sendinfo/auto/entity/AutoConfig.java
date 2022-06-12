package com.sendinfo.auto.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.sendinfo.auto.common.BaseModel;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@TableName("auto_config")
public class AutoConfig extends BaseModel {

    @Size(min=1, max=100, message = "名称长度在1-100之间")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotNull(message = "所属环境不能为空")
    private String envId;

    @NotBlank(message = "配置payId不能为空")
    private String payId;

    @NotBlank(message = "配置merchantId不能为空")
    private String merchantId;

    @NotBlank(message = "配置privateKey不能为空")
    private String privateKey;

    @NotBlank(message = "配置publicKey不能为空")
    private String publicKey;

    private static final long serialVersionUID = 1L;
}