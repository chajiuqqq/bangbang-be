package com.chajiu.bangbangbe;


import com.chajiu.bangbangbe.Mapper.SchoolMapper;
import com.chajiu.bangbangbe.entity.School;


import com.chajiu.bangbangbe.entity.User;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SchoolTest {
    @Autowired
    SchoolMapper mapper;

    @Test
    public void listSchools() {
        List<School> school = mapper.listSchools();
        System.out.println(school);
    }
    @Test
    public void selectById(){
        School school = mapper.selectById(1);
        System.out.println(school);
    }

    @Test
    public void selectByName(){
        School school = mapper.selectByName("shd");
        System.out.println(school);
    }
    @Test
    public void insertName(){
        mapper.insert(null);
    }
    @Test
    public void updateNameById(){
        mapper.updateNameById("sXX",2);
    }

    @Test
    public void deleteById(){
        mapper.deleteById(2);
    }

}
