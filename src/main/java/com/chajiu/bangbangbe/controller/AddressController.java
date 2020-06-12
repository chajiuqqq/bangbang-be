package com.chajiu.bangbangbe.controller;

import com.chajiu.bangbangbe.entity.Address;
import com.chajiu.bangbangbe.service.IAddressService;
import com.chajiu.bangbangbe.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
    IAddressService as;

    @Autowired
    ISessionService ss;

    /**
     * 获取一个用户所有地址
     * @param skey
     * @param res
     * @return
     */
    @RequestMapping("/addresses")
    public List<Address> listAllAddresses(String skey, HttpServletResponse res){
        String openid = ss.findOpenid(skey);
        if(openid == null){
            res.setStatus(400);
            return Arrays.asList(new Address());
        }

        List<Address> addresses = as.selectByOpenId(openid);
        return addresses;
    }

    @RequestMapping("/address")
    public Address add(String skey, @RequestBody Address address,HttpServletResponse res){
        String openid = ss.findOpenid(skey);

        if(openid == null){
            res.setStatus(400);
            return new Address();
        }
        address.setOpenId(openid);
        as.insertAddress(address);
        return address;
    }

    @RequestMapping(value = "/address/{id}",method = RequestMethod.DELETE)
    public void del(@PathVariable Integer id, HttpServletResponse res){
        try {
            as.deleteById(id);
        }catch (Exception e){
            res.setStatus(400);
        }
    }

    @RequestMapping(value = "/address/{id}",method=RequestMethod.PUT)
    public Address update(@PathVariable Integer id, @RequestBody Address address,HttpServletResponse res){
        try {
            address.setId(id);
            as.updateById(address);
            return address;
        }catch (Exception e){
            res.setStatus(400);
        }
        return new Address();
    }







}
