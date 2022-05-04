package com.sendinfo.auto;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 如果不写scanBasePackages，只会扫描当前包下的类，不会扫描其他模块包中的类，写了代表扫描com.sendinfo下面所有的类
//@SpringBootApplication(scanBasePackages = {"com.sendinfo"})
@SpringBootApplication
@MapperScan("com.sendinfo.auto.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}