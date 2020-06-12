package com.chajiu.bangbangbe.Mapper;

import com.chajiu.bangbangbe.entity.Order;

import com.chajiu.bangbangbe.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

     /**
      * 获取可用订单，依据为order的status为3（待接单）
      * @return
      */
     List<Order> getAvailableOrders();

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
     void addOrder(Order order);


     /**
      * 获取一个角色的所有订单
      * @param openid
      * @param identity 0表示普通用户订单，1表示接的单。
      *                 0时，请查询order表中customer_id == user.openId
      *                 1时，请查询order表中helper_id == user.openId
      * @return
      */
     List<Order> getUserOrders(String openid, int identity);

     /**
      * 接单操作，请置订单的status为0（正在进行）
      * @param orderId   订单编号
      * @param helper    接单者
      */
     void takeOrder(String orderId, User helper);

     /**
      * 完成订单，请置订单的status为1（已完成）
      * @param orderId 订单编号
      */
     void completeOrder(String orderId);


     /**
      * 取消订单，，请置订单的status为2（已取消）
      * @param orderId
      */
     void cancelOrder(String orderId);

     /**
      * 删除订单
      * @param orderId
      */
     void deleteByOrderId(String orderId);

}
