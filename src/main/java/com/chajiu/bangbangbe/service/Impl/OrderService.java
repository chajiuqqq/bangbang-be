package com.chajiu.bangbangbe.service.Impl;

import com.chajiu.bangbangbe.Mapper.OrderMapper;
import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IOrderService;
import com.chajiu.bangbangbe.service.IUserService;
import com.chajiu.bangbangbe.util.OrderStatus;
import com.chajiu.bangbangbe.util.PayStatus;
import com.chajiu.bangbangbe.util.ReviewStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderMapper mapper;
    @Autowired
    IUserService userService;

    @Override
    public List<Order> getAvailableOrders(String openid) {
        User user = userService.selectByOpenId(openid);
        List<Order> orders = mapper.getAvailableOrders();
        List<Order> availableOrders=new ArrayList<>();

        for(Order o:orders){
            User cust = userService.selectByOpenId(o.getCustomerId());
            if(cust.getSchoolId().equals(user.getSchoolId())){
                availableOrders.add(o);
            }
        }
        return availableOrders;

    }

    @Override
    public Order selectByOrderId(String orderId) {
        return mapper.selectByOrderId(orderId);
    }

    @Override
    public Order addOrder(Order order) throws Exception {
        Random random=new Random();
        order.setOrderId(String.valueOf(100000000 + random.nextInt(99999999)));

        order.setStatus(OrderStatus.WAITFORTAKE.ordinal());
        order.setPayStatus(PayStatus.NOTPAYED.ordinal());
        order.setReviewStatus(ReviewStatus.ON_REVIEWING.ordinal());

        User user = userService.selectByOpenId(order.getCustomerId());
        if(user == null){
            throw new Exception("该用户没有注册...");
        }
        order.setCustomerName(user.getNickname());

        mapper.addOrder(order);
        order = mapper.selectByOrderId(order.getOrderId());

        return order;
    }

    @Override
    public List<Order> getUserOrders(String openid, int identity) {
        return mapper.getUserOrders(openid,identity);
    }


    @Override
    public void takeOrder(String orderId, User helper) throws Exception {
        //帮手信息检验，没填写抛出异常
        if(helper.getName() == null || helper.getPhoneNumber() == null || helper.getIdentityId() == null){
            throw new Exception("帮手信息不全，无法接单...");
        }
        mapper.takeOrder(orderId,helper);

    }

    @Override
    public void completeOrder(String orderId, String openid) throws Exception {
        Order order = mapper.selectByOrderId(orderId);
        if(!order.getCustomerId().equals(openid)){
            throw new Exception("无操作权限...");
        }else{
            mapper.completeOrder(orderId);
        }

    }

    @Override
    public void cancelOrder(String orderId,String openid) throws Exception {
        Order order = mapper.selectByOrderId(orderId);
        if(!order.getCustomerId().equals(openid)){
            throw new Exception("无操作权限...");
        }else{
            mapper.cancelOrder(orderId);
        }
    }

    @Override
    public void deleteByOrderId(String orderId,String openid) throws Exception {
        Order order = mapper.selectByOrderId(orderId);
        if(!order.getCustomerId().equals(openid)){
            throw new Exception("无操作权限...");
        }else{
            mapper.deleteByOrderId(orderId);
        }
    }
}
