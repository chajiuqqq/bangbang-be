package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.util.MD5Util;
import org.junit.jupiter.api.Test;

public class utilTest {
    @Test
    public void test(){
        try {
            System.out.println(MD5Util.getMD5Str("wheeee"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
