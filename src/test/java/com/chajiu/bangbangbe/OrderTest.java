package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.Mapper.OrderMapper;
import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IOrderService;
import com.chajiu.bangbangbe.util.OrderStatus;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.chajiu.bangbangbe.util.OrderStatus.ON_PROCESSING;
import static com.chajiu.bangbangbe.util.ReviewStatus.ON_REVIEWING;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderMapper mapper;
    @Autowired
    IOrderService service;

    @Test
    public void getAvailableOrders() {
        List<Order> order = mapper.getAvailableOrders();
        System.out.println(order);
    }
//    @Test
//    public void selectbyId(){
//        Order order = mapper.selectbyOrderId("1");
//        System.out.println(order);
//    }
//
    @Test
    public void selectByOrderId(){
        Order order = mapper.selectByOrderId("1");
        System.out.println(order);
      }

    @Test
    public void addOrder() {
        Order order = new Order();
        order.setCustomerId("1111");
        order.setCustomerName("cname");
        order.setAmount("amount");
        order.setContent("content");
        order.setTargetAddress("taraddress");
        order.setAddress("address");
        order.setAddressee("addressee");
        order.setAddresseePhone("aphone");
        order.setArrivalTime("atime");
        order.setCustomerId("oy2b_42LsdtxbY20shz1smSlSdCM");

        try {
            service.addOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getUserOrders(){
        List<Order> order = mapper.getUserOrders( "user" ,1);
        System.out.println(order);
    }

    @Test
    public void deletebyOrderId() {
        Order order=new Order();
        System.out.println(order);
    }

 }








