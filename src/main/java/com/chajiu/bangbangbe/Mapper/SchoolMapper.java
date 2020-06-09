package com.chajiu.bangbangbe.Mapper;

import com.chajiu.bangbangbe.entity.School;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import com.chajiu.bangbangbe.entity.User;

@Mapper
public interface SchoolMapper {
     /**
      * 获取所有学校列表
      * @return
      */
     School listSchools();

     School selectbyId(int id);

     School selectbyName(String name);

     void insertname(String name);

     void updatenamebyId(String name ,int id);

     void deletebyId(int id);
}

