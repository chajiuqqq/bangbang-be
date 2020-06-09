package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.Mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper mapper;

    @Test
    public void listuser() {
        List<User> users= mapper.listuser();
        System.out.println(users);
    }

    @Test
    public void selectbyId(){
        User user = mapper.selectbyId(1);
        System.out.println(user);
    }

    @Test
    public void selectbyName(){
        List<User> users = mapper.selectbyName("zzb");
        System.out.println(users);
    }
    @Test
    public void insertname() {
        mapper.insertname("zzb");
    }
    @Test
    public void insertall(){
        User user = new User();
        user.setName("ZZZ");
        user.setUserName("ZZZZZ");
        user.setPassword("123456");
        user.setSchoolId(1);
        user.setSchoolName("shd");
        user.setPhoneNumber("12345678999");
        user.setIdentity(1);
        mapper.insertall(user);
    }
    @Test
    public void updatenamebyId(){
        mapper.updatenamebyId("zzzy",2);
    }

    @Test
    public void deletebyId(){
        mapper.deletebyId(2);
    }




}