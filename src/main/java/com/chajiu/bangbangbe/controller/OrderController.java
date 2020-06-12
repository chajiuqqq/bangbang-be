package com.chajiu.bangbangbe.controller;



import com.chajiu.bangbangbe.entity.Order;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IOrderService;
import com.chajiu.bangbangbe.service.ISessionService;

import com.chajiu.bangbangbe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    ISessionService sessionService;
    @Autowired
    IOrderService orderService;

    @Autowired
    IUserService userService;

    /**
     * 发布订单
     * @param skey
     * @param order
     * @param res
     * @return
     */
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public Order add(String skey, @RequestBody Order order, HttpServletResponse res){
        String openid = sessionService.findOpenid(skey);
        if(openid == null){
            res.setStatus(400);
            return new Order();
        }

        order.setCustomerId(openid);

        try {
            order = orderService.addOrder(order);
            return order;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            res.setStatus(400);
            return new Order();
        }

    }

    /**
     * 获取订单详情
     * @param id
     * @param res
     * @return
     */
    @RequestMapping("/order/{id}")
    public Order getDetail(@PathVariable String id,HttpServletResponse res){
        Order order = orderService.selectByOrderId(id);
        if(order == null){
            res.setStatus(400);
            return new Order();
        }

        return order;
    }

    /**
     * 获取可用订单（获取者和订单发布者在同一学校）
     * @param skey
     * @param res
     * @return
     */
    @RequestMapping("/availableOrders")
    public List<Order> getAvailableOrders(String skey,HttpServletResponse res){
        String openid = sessionService.findOpenid(skey);
        if(openid == null){
            res.setStatus(400);
            return Arrays.asList(new Order());
        }

        List<Order> availableOrders = orderService.getAvailableOrders(openid);
        return availableOrders;
    }

    /**
     * 获取一个角色所有订单
     * @param skey
     * @param identity 0表示普通用户订单，1表示接的单
     * @param res
     * @return
     */
    @RequestMapping("/orders")
    public List<Order> getOnesAllOrders(String skey,Integer identity, HttpServletResponse res){
        String openid = sessionService.findOpenid(skey);
        if(openid == null){
            res.setStatus(400);
            return Arrays.asList(new Order());
        }
        List<Order> userOrders = orderService.getUserOrders(openid, identity);
        return userOrders;
    }

    /**
     * 订单操作 包括取消订单 完成订单（确认收货） 抢单
     * @param skey
     * @param option 0表示接单，1表示确认收货，2表示取消订单
     * @param id
     * @param res
     */
    @RequestMapping(value = "/order/{id}",method = RequestMethod.PUT)
    public Order update(String skey, Integer option,@PathVariable String id,HttpServletResponse res){
        String openid = sessionService.findOpenid(skey);
        if(openid == null){
            res.setStatus(400);
            return new Order();
        }
        User helper = userService.selectByOpenId(openid);


        try {
            switch (option){
                case 0:
                    orderService.takeOrder(id,helper);
                    break;
                case 1:
                    orderService.completeOrder(id,openid);
                    break;
                case 2:
                    orderService.cancelOrder(id,openid);
                    break;
                default:
                    res.setStatus(400);
                    return new Order();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            res.setStatus(400);
            return new Order();
        }
        return orderService.selectByOrderId(id);

    }

    /**
     * 删除订单
     * @param orderid
     * @param skey
     * @param res
     */
    @RequestMapping(value = "/order/{id}",method = RequestMethod.DELETE)
    public void del(@PathVariable(name = "id") String orderid,String skey,HttpServletResponse res){
        String openid = sessionService.findOpenid(skey);
        if(openid == null){
            res.setStatus(400);
            return;
        }
        try {
            orderService.deleteByOrderId(orderid,openid);
        } catch (Exception e) {
            res.setStatus(400);
            return;
        }
    }







}
