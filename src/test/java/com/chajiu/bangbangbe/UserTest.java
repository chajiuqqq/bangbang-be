package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.entity.App;
import com.chajiu.bangbangbe.entity.Session;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.Mapper.UserMapper;

import com.chajiu.bangbangbe.service.ISessionService;
import com.chajiu.bangbangbe.service.IUserService;
import com.chajiu.bangbangbe.util.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper mapper;

    @Autowired
    ISessionService ss;

    @Test
    public void testLogin() throws Exception {
        String code = "061M4CzM1rPr6a1P61BM173BzM1M4CzS";

        Session session = ss.login(code);
        System.out.println(session);

    }

}