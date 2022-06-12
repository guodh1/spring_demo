package com.sendinfo.auto.common.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

public enum ParamEnum {

    PAY_PARAM("1", "支付"),

    REFUND_PARAM("2", "退款"),

    QUERY_PARAM("3", "支付查询"),

    REFUND_QUERY_PARAM("4", "退款查询"),

    REVERSE_PARAM("5", "撤销"),

    CLOSE_PARAM("6", "关闭");


    ParamEnum(String id, String type) {
        this.id = id;
        this.type = type;
    }

    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static List<HashMap<String, String>> getList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        for (ParamEnum warehouseTypeEnum : EnumSet.allOf(ParamEnum.class)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("value", warehouseTypeEnum.id);
            map.put("label", warehouseTypeEnum.type);
            list.add(map);
        }
        return list;
    }

}
