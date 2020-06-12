package com.chajiu.bangbangbe.service;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.entity.User;

import java.util.List;

public interface IAddressService {

    List<Address> selectByOpenId(String openId);
    /**
     * 根据address的id修改address信息
     * @param address 传入address对象，id是旧id，其他内容是新内容
     */
    void updateById(Address address);

    /**
     * 依据address的id删除address
     * @param id address的id
     */
    void deleteById(int id);

    /**
     * 插入地址信息
     * @param address 新的address对象，id为空
     */
    void insertAddress(Address address);

}
