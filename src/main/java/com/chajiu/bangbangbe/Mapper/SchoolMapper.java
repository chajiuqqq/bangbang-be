package com.chajiu.bangbangbe.Mapper;

import com.chajiu.bangbangbe.entity.School;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import com.chajiu.bangbangbe.entity.User;

import java.util.List;

@Mapper
public interface SchoolMapper {
     /**
      * 获取所有学校列表
      * @return
      */
     List<School> listSchools();

     School selectById(int id);

     School selectByName(String name);

     void insertName(String name);

     void updateNameById(String name ,int id);

     void deleteById(int id);
}

