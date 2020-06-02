package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.Mapper.OrderMapper;
import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderMapper mapper;

    @Test
    public void listorder() {
        Order order = mapper.listorder();
        System.out.println(order);
    }
    @Test
    public void selectbyId(){
        Order order = mapper.selectbyId(1);
        System.out.println(order);
    }

    @Test
    public void selectbyOrderId(){
        Order order = mapper.selectbyOrderId("3333");
        System.out.println(order);
    }
    @Test
    public void insertOrderId() {
        Order order = new Order();
        order.setOrderId("3333");
        mapper.insertOrderId(order.getOrderId());
    }
    @Test
    public void updateAddressbyOrderId(){
        mapper.updateAddressbyOrderId("bbbbbbbb","2222");
    }

    @Test
    public void deletebyOrderId(){
        mapper.deletebyOrderId("2222");
    }







}
