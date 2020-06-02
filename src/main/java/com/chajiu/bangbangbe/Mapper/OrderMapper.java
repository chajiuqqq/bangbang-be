package com.chajiu.bangbangbe.Mapper;

import com.chajiu.bangbangbe.entity.Order;

import com.chajiu.bangbangbe.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    @Select("select * from orders")
    public Order listorder();

    @Select("select * from orders where id=#{id}")
    public Order selectbyId(int id);

    @Select("select * from orders where order_id=#{OrderId}")
    public Order selectbyOrderId(String OrderId);

    @Insert("insert into orders(order_id) values(#{OrderId})")
    public void insertOrderId(String OrderId);

    @Update("update orders set address=#{address} where order_id=#{order_id}")
    public void updateAddressbyOrderId(String address ,String order_id);

    @Delete("delete from orders where order_id=#{order_id}")
    public void deletebyOrderId(String order_id);
}
