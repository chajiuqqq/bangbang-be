package com.chajiu.bangbangbe.service.Impl;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Override
    public void addAddress(Address address) {

    }

    @Override
    public List<Address> getOnesAllAddress(int uid) {
        return null;
    }

    @Override
    public List<Address> getOnesAllAddress(User user) {
        return null;
    }
}
