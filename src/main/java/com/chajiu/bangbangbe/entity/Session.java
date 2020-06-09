package com.chajiu.bangbangbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    private  Integer id;
    private String openId;
    private String sessionKey;
    private String skey;
    private Date lastLoginTime;
}
