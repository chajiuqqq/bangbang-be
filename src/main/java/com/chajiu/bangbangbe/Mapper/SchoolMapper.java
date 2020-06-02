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
    @Select("select * from school")
    public School listschool();

    @Select("select * from school where id=#{id}")
    public School selectbyId(int id);

    @Select("select * from school where name=#{name}")
    public School selectbyName(String name);

    @Insert("insert into school(name) values(#{name})")
    public void insertname(String name);

    @Update("update school set name=#{name} where id=#{id}")
    public void updatenamebyId(String name ,int id);

    @Delete("delete from school where id=#{id}")
    public void deletebyId(int id);
}

