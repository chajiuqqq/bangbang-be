package com.chajiu.bangbangbe;


import com.chajiu.bangbangbe.Mapper.SchoolMapper;
import com.chajiu.bangbangbe.entity.School;


import com.chajiu.bangbangbe.entity.User;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SchoolTest {
    @Autowired
    SchoolMapper mapper;

    @Test
    public void listschool() {
        School school = mapper.listschool();
        System.out.println(school);
    }
    @Test
    public void selectbyId(){
        School school = mapper.selectbyId(1);
        System.out.println(school);
    }

    @Test
    public void selectbName(){
        School school = mapper.selectbyName("shd");
        System.out.println(school);
    }
    @Test
    public void insertname(){
        mapper.insertname("shd");
    }
    @Test
    public void updatenamebyId(){
        mapper.updatenamebyId("shd",1);
    }

    @Test
    public void deletebyId(){
        mapper.deletebyId(1);
    }

}
