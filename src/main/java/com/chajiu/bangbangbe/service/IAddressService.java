package com.chajiu.bangbangbe.service;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.entity.User;

import java.util.List;

public interface IAddressService {
    void addAddress(Address address);
    List<Address> getOnesAllAddress(int uid);
    List<Address> getOnesAllAddress(User user);


}
