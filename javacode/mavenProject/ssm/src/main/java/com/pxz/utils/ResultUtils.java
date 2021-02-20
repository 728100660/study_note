package com.pxz.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
    public static Map getResult(Object data, int code ){
        /*将结果打包成   {code:code    data:data} 的标准返回格式*/
        Map<Object, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("data",data);
        map.put("msg", "");
        return map;
    }

    public static Map getResult(Object data, int code, String msg ){
        /*将结果打包成   {code:code    data:data} 的标准返回格式*/
        Map<Object, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("data",data);
        map.put("msg",msg);
        return map;
    }
}
