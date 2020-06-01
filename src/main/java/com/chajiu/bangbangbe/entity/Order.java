package com.chajiu.bangbangbe.entity;

import com.chajiu.bangbangbe.util.OrderStatus;
import com.chajiu.bangbangbe.util.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private Integer orderId;
    private OrderStatus status;
    private Integer customerId;
    private String customerName;
    private Integer helperId;
    private String helperName;
    private String helperPhone;
    private String amount;
    private String content;
    private String targetAddress;
    private String address;
    private String addressee;
    private String addresseePhone;
    private String confirmCode;
    private Integer payStatus;
    private ReviewStatus reviewStatus;
}
