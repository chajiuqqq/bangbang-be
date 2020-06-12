package com.chajiu.bangbangbe.service;

import com.chajiu.bangbangbe.entity.App;
import com.chajiu.bangbangbe.entity.Session;

public interface ISessionService {
    /**
     * 登录，把里面的属性都存进去
     * @param session
     */
    void add(Session session);
    /**
     * 依据openid更新session_key和skey
     * @param session
     */
    void update(Session session);

    /**
     * 依据openid查找是否有记录
     * @param openid
     * @return
     */
    Boolean exist(String openid);

    public Session login(String code) throws Exception;


    String findOpenid(String skey);
}
