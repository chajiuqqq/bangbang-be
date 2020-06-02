package com.chajiu.bangbangbe.Mapper;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import com.chajiu.bangbangbe.entity.User;

@Mapper
public interface Usermapper {
    @Select("select * from user")
    public User listuser();

    @Select("select * from user where id=#{id}")
    public User selectbyId(int id);

    @Select("select * from user where name=#{name}")
    public User selectbyName(String name);

    @Insert("insert into user(name) values(#{name})")
    public void insertname(String name);

    @Insert("insert into user(name,username,password,school_id,school_name,phone_number,identity) values(#{name},#{userName},#{password}," +
            "#{schoolId},#{schoolName},#{phoneNumber},#{identity})")
    public void insertall(User user);

    @Update("update user set name=#{name} where id=#{id}")
    public void updatenamebyId(String name ,int id);

    @Delete("delete from user where id=#{id}")
    public void deletebyId(int id);
}