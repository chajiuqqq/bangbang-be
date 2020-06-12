package com.chajiu.bangbangbe.entity;


import com.chajiu.bangbangbe.util.UrlUtil;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static String appid = "wx5f2aa8ded12eb5eb";
    public static String secret = "dcd11b6e3e7eff39d1b099dc4fa0d258";
    public static String grant_type="authorization_code";
    public static String js_code="";

    public static String toParams(){
        Map<String,String> map = new HashMap<>();
        map.put("appid",appid);
        map.put("secret",secret);
        map.put("grant_type",grant_type);
        map.put("js_code",js_code);
        return UrlUtil.toParamsStr(map);
    }

}
