package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.util.HttpUtil;
import com.chajiu.bangbangbe.util.MD5Util;
import com.chajiu.bangbangbe.util.UrlUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jdk.nashorn.internal.ir.PropertyNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class utilTest {
    @Test
    public void test(){
        try {
            System.out.println(MD5Util.getMD5Str("wheeee"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get() throws JsonProcessingException {
        Map<String,String> map = new HashMap<>();
        map.put("name","zyy");
        map.put("id","1234");
        String url="http://rap2.taobao.org:38080/app/mock/256781/make?"+ UrlUtil.toParamsStr(map);
        System.out.println(url);


        String s = HttpUtil.sendGet(url);
        System.out.println(s);

        ObjectMapper mapper= new ObjectMapper();
        ObjectNode objectNode = mapper.readValue(s, ObjectNode.class);

        JsonNode list = objectNode.findValue("list");
        System.out.println(list);


    }
}
