package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.Mapper.AddressMapper;

import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressTest {
    @Autowired
    AddressMapper mapper;

    @Test
    public void listaddress() {
        Address address = mapper.listaddress();
        System.out.println(address);
    }

    @Test
    public void selectbyId() {
        Address address = mapper.selectbyId(1);
        System.out.println(address);
    }

    @Test
    public void selectbyUserId() {
        Address address = mapper.selectbyUserId(1);
        System.out.println(address);
    }

    @Test
    public void insertaddress() {
        mapper.insertuserId(1);
    }

    @Test
    public void updateAddressbyUserId() {
        mapper.updateAddressbyUserId("aaaaaa", 1);
    }

    @Test
    public void deletebyUserId(){
        mapper.deletebyUserId(1);
    }
}