package com.chajiu.bangbangbe.entity;

import com.chajiu.bangbangbe.util.OrderStatus;
import com.chajiu.bangbangbe.util.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;


@Data
@AllArgsConstructor
public class Order {
    private Integer id;
    private String orderId;
    /**
     * 0正在进行 1已完成 2已取消 3待接单
     */
    private Integer status;
    private String customerId;
    private String customerName;
    private String helperId;
    private String helperName;
    private String helperPhone;
    private String amount;
    private String content;
    private String targetAddress;
    private String address;
    private String addressee;
    private String addresseePhone;
    private String confirmCode;
    /**
     * 0未支付 1已支付
     */
    private Integer payStatus;
    /**
     * 0审核中 1已通过 2未通过
     */
    private Integer reviewStatus;
    private Date createTime;
    private String arrivalTime;

    public Order() {
        createTime = new Date();
    }
}
