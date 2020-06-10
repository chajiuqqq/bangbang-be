package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.Mapper.OrderMapper;
import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.util.OrderStatus;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.chajiu.bangbangbe.util.OrderStatus.ON_PROCESSING;
import static com.chajiu.bangbangbe.util.ReviewStatus.ON_REVIEWING;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderMapper mapper;

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
        order.setOrderId("7777");
        order.setStatus(null);
        order.setCustomerId(1111);
        order.setCustomerName("cname");
        order.setHelperId(2222);
        order.setHelperName("hname");
        order.setHelperPhone("hphone");
        order.setAmount("amount");
        order.setContent("content");
        order.setTargetAddress("taraddress");
        order.setAddress("address");
        order.setAddressee("addressee");
        order.setAddresseePhone("aphone");
        order.setConfirmCode("ccode");
        order.setPayStatus(1);
        order.setReviewStatus(null);
        order.setCreateTime(null);
        order.setArrivalTime("atime");
        order.setSkey("skey");
        Integer integer = mapper.addOrder(order);
        System.out.println(integer);
    }
    @Test
    public void getUserOrders(){
        User user = new User();
        user.setOpenId("111111");
        List<Order> order = mapper.getUserOrders( user ,1);
        System.out.println(order);
    }

//    @Test
//    public void deletebyOrderId(){
//        mapper.deletebyOrderId("2222");
 }








