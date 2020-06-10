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

//    @Test
//    public void listuser() {
//        List<User> users= mapper.listuser();
//        System.out.println(users);
//    }
//
    @Test
    public void selectByOpenId(){
        User user = mapper.selectByOpenId(1);
        System.out.println(user);
    }
//
//    @Test
//    public void selectbyName(){
//        List<User> users = mapper.selectbyName("zzb");
//        System.out.println(users);
//    }
//    @Test
//    public void insertname() {
//        mapper.insertname("zzb");
//    }
    @Test
    public void insert(){
        User user = new User();
        user.setName("ZZZ");
        user.setName("ZZZZZ");
        user.setSchoolId(1);
        user.setSchoolName("shd");
        user.setPhoneNumber("12345678999");
        user.setIdentity(1);
        mapper.insert(user);
    }
    @Test
    public void update(){
        User user = new User();
        user.setId(4);
        user.setNickname(null);
        user.setName("AAAA");
        user.setPhoneNumber("555555");
        mapper.update(user);
    }

//    @Test
//    public void deletebyId(){
//        mapper.deletebyId(2);
//    }




}