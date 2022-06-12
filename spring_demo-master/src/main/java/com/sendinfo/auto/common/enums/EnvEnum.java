package com.sendinfo.auto.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

public enum EnvEnum {
    TEST_ENV("1", "测试环境"),

    STABLE_ENV("2", "预发环境"),

    PRO_ENV("3", "生产环境");

    private  String  id;
    private String env;

    public String getId() {
        return id;
    }

    public void setId(String i) {
        this.id = i;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    EnvEnum(String i, String env) {
        this.id = i;
        this.env = env;
    }

//    public static Map<String, String> getMap() {
//        Map<String, String> map = Arrays.stream(EnvEnum.values()).collect(Collectors.toMap
//                (EnvEnum::getId, EnvEnum::getEnv));
//        return map;
//    }

    public static List<HashMap<String, String>> getList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        for (EnvEnum warehouseTypeEnum : EnumSet.allOf(EnvEnum.class)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("value", warehouseTypeEnum.id);
            map.put("label", warehouseTypeEnum.env);
            list.add(map);
        }
        return list;
    }

}
