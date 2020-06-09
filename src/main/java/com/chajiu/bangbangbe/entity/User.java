package com.chajiu.bangbangbe.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String nickname;
    private String name;
    private Integer schoolId;
    private String schoolName;
    private String phoneNumber;
    //0表示普通用户 1表示帮手
    private Integer identity;
    private String avatarUrl;
    private String openId;
    private String identityId;
}
