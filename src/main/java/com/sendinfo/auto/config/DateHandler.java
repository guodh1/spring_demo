package com.sendinfo.auto.config;

import org.apache.ibatis.reflection.MetaObject;
import java.util.Date;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.springframework.stereotype.Component;


@Component
public class DateHandler implements MetaObjectHandler{
    // mybatis-plus提供的功能，可以在插入数据或更新数据时自动更新时间
    // 自动填充，意味着就是设置默认值，不依赖数据库设置默认值，依赖程序实现
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("添加插入时间");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("author", "guodh", metaObject);
        this.setFieldValByName("editor", "guodh", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("添加更新时间");
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("editor", "guodh1", metaObject);
    }

}
