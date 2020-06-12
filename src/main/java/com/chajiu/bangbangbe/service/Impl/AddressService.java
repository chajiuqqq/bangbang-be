package com.chajiu.bangbangbe.service.Impl;

import com.chajiu.bangbangbe.Mapper.AddressMapper;
import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Autowired
    AddressMapper mapper;

    @Override
    public List<Address> selectByOpenId(String openId) {
        return mapper.selectByOpenId(openId);
    }

    @Override
    public void updateById(Address address) {
        mapper.updateById(address);
    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);
    }

    @Override
    public void insertAddress(Address address) {
        mapper.insertAddress(address);
    }
}
