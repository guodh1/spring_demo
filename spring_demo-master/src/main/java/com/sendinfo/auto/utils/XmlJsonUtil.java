package com.sendinfo.auto.utils;

import org.json.JSONObject;
import org.json.XML;

public class XmlJsonUtil {
//    Map<String, String> map = new HashMap<>();
//        map.put("k1", "v1");
//        map.put("k2", "v2");
//
//    //json串
//    String jsonStr = JSON.toJSONString(map);
//        System.out.println("source json : " + jsonStr);
//
//    //json转xml
//    String xml = json2xml(jsonStr);
//        System.out.println("xml  :  " + xml);
//    //xml转json
//    String targetJson = xml2json(xml);
//        System.out.println("target json : " + targetJson);

    public static String jsonToXml(String json) {
        JSONObject jsonObj = new JSONObject(json);
        return "<xml>" + XML.toString(jsonObj) + "</xml>";
    }

    public static String xmlToJson(String xml) {
        JSONObject xmlJSONObj = XML.toJSONObject(xml.replace("<xml>", "").replace("</xml>", ""));
        return xmlJSONObj.toString();
    }

}
