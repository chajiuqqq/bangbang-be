package com.chajiu.bangbangbe.controller;


import com.chajiu.bangbangbe.entity.Session;
import com.chajiu.bangbangbe.entity.User;
import com.chajiu.bangbangbe.service.IUserService;
import com.chajiu.bangbangbe.service.Impl.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    SessionService ss;

    @Autowired
    IUserService us;

    /**
     * 登录操作
     * @param code
     * @param res
     * @return
     */
    @RequestMapping("/user/login")
    public Map<String,String> login(String code,HttpServletResponse res){

        Map<String,String> map = new HashMap<>();
        Session session = null;
        try {
            session = ss.login(code);
        } catch (Exception e) {
            res.setStatus(400);
            map.put("errmsg",e.getMessage());
            return map;
        }

        //返回skey
        map.put("skey",session.getSkey());
        return map;
    }

    /**
     * 获取用户信息
     * @param skey
     * @param res
     * @return
     */
    @RequestMapping("/user")
    public User getUserInfo(String skey, HttpServletResponse res){

        String openid = ss.findOpenid(skey);
        try {
            User user = us.selectByOpenId(openid);
            return user;
        }catch (NullPointerException e){
            res.setStatus(400);
        }

        return new User();
    }

    /**
     * 更新用户信息
     * @param
     * @param res
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public User updateUserInfo(String skey, @RequestBody User user, HttpServletResponse res){
        String openid="";
        try {
            openid = ss.findOpenid(skey);
        }catch (Exception e){
            res.setStatus(400);
        }

        user.setOpenId(openid);

        try {
            us.update(user);
            user = us.selectByOpenId(openid);
        }catch (Exception e){
            res.setStatus(400);
        }
        return user;

    }

    /**
     * 添加用户信息
     * @param skey
     * @param res
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User addUser(String skey, @RequestBody User user, HttpServletResponse res){
        String openid="";
        try {
            openid = ss.findOpenid(skey);
        }catch (Exception e){
            res.setStatus(400);
        }

        user.setOpenId(openid);

        try {
            us.insert(user);
            user = us.selectByOpenId(openid);
        }catch (Exception e){
            res.setStatus(400);
        }
        return user;
    }


}
