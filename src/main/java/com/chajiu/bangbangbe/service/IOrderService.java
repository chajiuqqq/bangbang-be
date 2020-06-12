package com.chajiu.bangbangbe.service;

import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;

import java.util.List;

public interface IOrderService {

    /**
     * 获取可用订单，依据为order的status为3（待接单）
     * @return
     */
    List<Order> getAvailableOrders(String openid);

    /**
     * 获取订单详情
     * @param orderId orderId,不是id
     * @return
     */
    Order selectByOrderId(String orderId);

    /**
     * 发布订单
     * @param order 订单本体
     * @return 新建的order的id
     */
    Order addOrder(Order order) throws Exception;


    /**
     * 获取一个角色的所有订单
     * @param openid user对象
     * @param identity 0表示普通用户订单，1表示接的单。
     *                 0时，请查询order表中customer_id == user.openId
     *                 1时，请查询order表中helper_id == user.openId
     * @return
     */
    List<Order> getUserOrders(String openid, int identity);

    /**
     * 接单操作，请置订单的status为0（正在进行）
     * @param orderId   订单编号
     * @param helper
     */
    void takeOrder(String orderId,User helper) throws Exception;

    /**
     * 完成订单，请置订单的status为1（已完成）
     * @param orderId 订单编号
     */
    void completeOrder(String orderId, String openid) throws Exception;

    /**
     * 取消订单，，请置订单的status为2（已取消）
     * @param orderId
     */
    void cancelOrder(String orderId,String openid) throws Exception;

    /**
     * 删除订单
     * @param orderId
     */
    void deleteByOrderId(String orderId,String openid) throws Exception;

}
