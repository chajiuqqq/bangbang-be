package com.chajiu.bangbangbe;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.Mapper.AddressMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AddressTest {
    @Autowired
    AddressMapper mapper;

//    @Test
//    public void listaddress() {
//        Address address = mapper.listaddress();
//        System.out.println(address);
//    }
//
    @Test
    public void selectById() {
        Address address = mapper.selectById(1);
        System.out.println(address);
    }

    @Test
    public void selectByOpenId() {
        List<Address> address = mapper.selectByOpenId("1");
        System.out.println(address);
    }
//
    @Test
    public void insertAddress() {
        Address address = new Address();
        address.setOpenId("1");
        address.setAddress("aaaaa");
        address.setPhone("123456");
        address.setAddressee("bbbbb");
        mapper.insertAddress(address);
        System.out.println(address);
    }
//
    @Test
    public void updateById() {
        Address address = new Address();
        address.setId(5);
        address.setAddress("cccccddd");
        address.setPhone("1234567");
        address.setAddressee("ddddd");
        mapper.updateById(address);
    }


    @Test
    public void deleteById(){
        mapper.deleteById(1);
    }
}