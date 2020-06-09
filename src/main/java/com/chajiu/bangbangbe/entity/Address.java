package com.chajiu.bangbangbe.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Integer id;
    private Integer openId;
    private String address;
    private String phone;
    private String addressee;
}
