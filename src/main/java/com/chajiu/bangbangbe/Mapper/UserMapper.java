package com.chajiu.bangbangbe.Mapper;


import org.apache.ibatis.annotations.Mapper;

import com.chajiu.bangbangbe.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 添加用户信息
     * @param user
     */
    void insert(User user);

    /**
     * 更新用户信息，请用动态sql进行属性为空判断，若为空则不进行更新
     * @param user
     */
    void update(User user);

    /**
     * 使用openid获取用户信息
     * @param openId
     * @return
     */
    User selectByOpenId(int openId);



}