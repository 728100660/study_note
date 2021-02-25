package com.pxz.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    public static String getJson(Object object){
//        获取jackson对象
        ObjectMapper mapper = new ObjectMapper();
//        定义结果字符串
        String res = null;
        try {
//            将需要json序列话的对象json序列化并保存到res字符串中
            res = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        返回
        return res;
    }

    public static Object jsonToObj(String str, Object obj){
        /**好像不能用**/
        ObjectMapper mapper = new ObjectMapper();

        Object result = null;
        try {
            result = mapper.readValue(str, obj.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
