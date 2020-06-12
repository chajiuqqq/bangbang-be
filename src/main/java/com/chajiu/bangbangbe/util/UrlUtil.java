package com.chajiu.bangbangbe.util;

import java.util.Map;

public class UrlUtil {
    public static String toParamsStr(Map<String,String> map){
        String end="";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            end += entry.getKey();
            end += "=";
            end += entry.getValue();
            end += "&";
        }

        return  end.substring(0,end.length()-1);
    }
}
