package com.chajiu.bangbangbe;


import com.chajiu.bangbangbe.entity.Session;
import com.chajiu.bangbangbe.Mapper.SessionMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class SessionTest {
    @Autowired
    SessionMapper mapper;

    @Test
    public void add() throws ParseException {
        Session session = new Session();
        session.setId(1);
        session.setOpenId("3333");
        session.setSessionKey("www");
        session.setSkey("qqq");
        Date date = new Date();
        String str = "2000-01-01";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.parse(str);
        session.setLastLoginTime(date);
        mapper.add(session);
    }

    @Test
    public void find(){
        System.out.println(mapper.exist("oy2b_42LsdtxbY20shz1smSlSdCM"));
    }

    @Test
    public void update(){
        Session session=new Session();
        session.setOpenId("oy2b_42LsdtxbY20shz1smSlSdCM");
        session.setSessionKey("sadasdadasd");
        session.setSkey("sdsdsdsdsdsdsdsd");

        mapper.update(session);
    }

}
