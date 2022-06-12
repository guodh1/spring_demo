package com.sendinfo.auto.utils;

import com.alibaba.fastjson.JSON;

public class FastJsonHelper {

       /**
         * 将JSON格式的字符串转换为java类型的对象或者java数组类型的对象，不包括java集合类型
         * @param json JSON格式的字符串
         * @param clz java类型或者java数组类型，不包括java集合类型
         * @return java类型的对象或者java数组类型的对象，不包括java集合类型的对象
         */
        public static <T> T deserialize(String json, Class<T> clz) {
            return JSON.parseObject(json, clz);
    }
}
