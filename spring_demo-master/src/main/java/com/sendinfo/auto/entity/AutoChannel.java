package com.sendinfo.auto.entity;

import com.sendinfo.auto.common.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AutoChannel extends BaseModel {

    @Size(min = 1,max = 100,message = "用户名长度在1-100之间")
    @NotEmpty(message = "用户名不能为空")
    private String name;

    @NotEmpty(message = "支付产品码不能为空")
    private String payProductCode;

    @NotEmpty(message = "渠道产品码不能为空")
    private String channelProductCode;

    private static final long serialVersionUID = 1L;
}