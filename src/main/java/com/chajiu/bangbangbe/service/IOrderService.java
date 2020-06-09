package com.chajiu.bangbangbe.service;

import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;

import java.util.List;

public interface IOrderService {
    /**
     * 添加订单
     * @param order
     */
    void addOrder(Order order);

    /**
     * 删除订单
     * @param order order对象
     */
    void delOrder(Order order);

    /**
     * 删除订单
     * @param orderId orderId字段
     */
    void delOrder(String orderId);


    /**
     * 查找订单
     * @param orderId
     * @return
     */
    Order getOrder(String orderId);
    Order getOrder(Order order);


    /**
     * 查询一个用户的所有订单
     * @param uid
     * @return
     */
    List<Order> getOnesAllOrders(int uid);
    List<Order> getOnesAllOrders(User user);

    /**
     * 修改订单 传入order对象，包含原始orderId，和新的信息
     * @param order
     */
    void updateOrder(Order order);



}
