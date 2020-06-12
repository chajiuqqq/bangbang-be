package com.chajiu.bangbangbe.service.Impl;

import com.chajiu.bangbangbe.Mapper.UserMapper;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User selectByOpenId(String openId) {
        return mapper.selectByOpenId(openId);
    }

    @Override
    public void update(User user) {
        mapper.update(user);
    }

    @Override
    public void insert(User user) {
        mapper.insert(user);
    }
}
