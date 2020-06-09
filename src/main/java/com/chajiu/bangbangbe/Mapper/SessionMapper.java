package com.chajiu.bangbangbe.Mapper;


import com.chajiu.bangbangbe.entity.Session;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionMapper {
    /**
     * 登录，把里面的属性都存进去
     * @param session
     */
    void add(Session session);
}
