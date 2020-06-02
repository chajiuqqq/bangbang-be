package com.chajiu.bangbangbe.Mapper;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    @Select("select * from address")
    public Address listaddress();

    @Select("select * from address where id=#{id}")
    public Address selectbyId(int id);

    @Select("select * from address where user_id=#{id}")
    public Address selectbyUserId(int id);

    @Insert("insert into address(user_id) values(#{user_id})")
    public void insertuserId(int user_id);

    @Update("update address set address=#{address} where user_id=#{user_id}")
    public void updateAddressbyUserId(String address ,int user_id);

    @Delete("delete from address where user_id=#{user_id}")
    public void deletebyUserId(int user_id);


}
