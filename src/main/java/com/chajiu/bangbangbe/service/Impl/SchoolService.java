package com.chajiu.bangbangbe.service.Impl;

import com.chajiu.bangbangbe.Mapper.SchoolMapper;
import com.chajiu.bangbangbe.entity.School;
import com.chajiu.bangbangbe.service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {
    @Autowired
    SchoolMapper mapper;

    @Override
    public List<School> listSchools() {
        return mapper.listSchools();
    }

    @Override
    public School add(String name) {
        School school=new School();
        school.setName(name);
        mapper.insert(school);
        return school;
    }
}
