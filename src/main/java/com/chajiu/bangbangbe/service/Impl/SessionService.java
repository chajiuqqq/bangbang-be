package com.chajiu.bangbangbe.service.Impl;

import com.chajiu.bangbangbe.Mapper.SessionMapper;
import com.chajiu.bangbangbe.entity.App;
import com.chajiu.bangbangbe.entity.Session;
import com.chajiu.bangbangbe.service.ISessionService;
import com.chajiu.bangbangbe.util.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService implements ISessionService {
    @Autowired
    SessionMapper sm;

    @Override
    public void add(Session session) {
        sm.add(session);
    }

    @Override
    public void update(Session session) {
        sm.update(session);
    }

    @Override
    public Boolean exist(String openid) {
        if(sm.exist(openid) == 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Session login(String code) throws Exception {

        //利用code获取open_id
        App.js_code=code;

        String url = "https://api.weixin.qq.com/sns/jscode2session?" + App.toParams();

        String res = HttpUtil.sendGet(url);


        ObjectMapper mapper= new ObjectMapper();
        ObjectNode objectNode=null;
        try {
            objectNode = mapper.readValue(res, ObjectNode.class);
        } catch (JsonProcessingException e) {
            throw new Exception("请求openid时response解析错误...");
        }

        Session session=new Session();
        JsonNode errcode = objectNode.findValue("errcode");
        if( errcode == null ){
            session.setOpenId(objectNode.findValue("openid").asText());
            session.setSessionKey(objectNode.findValue("session_key").asText());
            session.genSkey();
            try {
                if(!exist(session.getOpenId())){
                    //保存session
                    add(session);
                }else{
                    //更新
                    update(session);
                }
            }catch (Exception e){
                throw new Exception("数据库保存异常..."+e.getMessage());
            }


        }else{
            throw new Exception("获取open_id失败...res:"+ res);
        }
        return session;
    }

    @Override
    public String findOpenid(String skey) {
        return sm.findOpenid(skey);
    }
}
