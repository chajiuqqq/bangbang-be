package com.chajiu.bangbangbe.service;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Override
    public void fun() {
        System.out.println("hello");
    }
}
