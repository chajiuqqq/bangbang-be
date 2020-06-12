package com.chajiu.bangbangbe.entity;

import com.chajiu.bangbangbe.util.MD5Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
public class Session {

    private  Integer id;
    private String openId;
    private String sessionKey;
    private String skey;
    private Date lastLoginTime;

    public Session() {
        lastLoginTime = new Date();
    }

    public void genSkey(){
        try {
            skey = MD5Util.getMD5Str(sessionKey);
        } catch (Exception e) {
            System.out.println("MD5生成失败...");
        }

    }
}
