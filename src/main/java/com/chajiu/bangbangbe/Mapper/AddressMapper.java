package com.chajiu.bangbangbe.Mapper;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

//     Address listaddress();

     /**
      * 依据address的id查找address
      * @param id
      * @return
      */
     Address selectbyId(int id);

     /**
      * 通过open_id找所有地址
      * @param openId
      * @return
      */
     List<Address> selectByOpenId(int openId);

//     void insertuserId(int user_id);

     /**
      * 根据address的id修改address信息
      * @param address 传入address对象，id是旧id，其他内容是新内容
      */
     void updateById(Address address);

     /**
      * 依据address的id删除address
      * @param id address的id
      */
     void deleteById(int id);

     /**
      * 插入地址信息
      * @param address 新的address对象，id为空
      */
     void insertAddress(Address address);




}
