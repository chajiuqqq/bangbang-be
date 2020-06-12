package com.chajiu.bangbangbe.controller;

import com.chajiu.bangbangbe.entity.School;
import com.chajiu.bangbangbe.service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    ISchoolService schoolService;

    @RequestMapping("/schools")
    public List<School> findAll(HttpServletResponse res){

        try {
            return schoolService.listSchools();
        }catch (Exception e){
            res.setStatus(400);
        }
        return Arrays.asList(new School());
    }


    @RequestMapping(value = "/school",method = RequestMethod.POST)
    public School add(String name){
        School add = schoolService.add(name);
        return add;
    }
}
