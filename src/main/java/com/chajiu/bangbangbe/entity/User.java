package com.chajiu.bangbangbe.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private Integer schoolId;
    private String schoolName;
    private String phoneNumber;
    //0表示普通用户 1表示帮手
    private Integer identity;
}
