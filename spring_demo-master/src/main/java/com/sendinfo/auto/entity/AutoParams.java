package com.sendinfo.auto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sendinfo.auto.common.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@TableName("auto_params")
public class AutoParams extends BaseModel {

    @NotBlank(message = "参数不能为空")
    private String params;

    @NotBlank(message = "参数类型不能为空")
    private String type;

    @NotBlank(message = "请求方法不能为空")
    private String method;

    @NotBlank(message = "请求路径不能为空")
    private String path;


    private static final long serialVersionUID = 1L;
}