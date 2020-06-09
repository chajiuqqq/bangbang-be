package com.chajiu.bangbangbe.service.Impl;

import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void delOrder(Order order) {

    }

    @Override
    public void delOrder(String orderId) {

    }

    @Override
    public Order getOrder(String orderId) {
        return null;
    }

    @Override
    public Order getOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> getOnesAllOrders(int uid) {
        return null;
    }

    @Override
    public List<Order> getOnesAllOrders(User user) {
        return null;
    }

    @Override
    public void updateOrder(Order order) {

    }
}
