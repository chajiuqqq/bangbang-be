package com.chajiu.bangbangbe.service;


import com.chajiu.bangbangbe.entity.User;
import org.springframework.stereotype.Service;

public interface IUserService {

    User selectByOpenId(String openId);


    void update(User user);

    void insert(User user);
}
