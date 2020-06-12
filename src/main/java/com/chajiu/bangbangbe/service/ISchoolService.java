package com.chajiu.bangbangbe.service;

import com.chajiu.bangbangbe.entity.School;

import java.util.List;

public interface ISchoolService {

    List<School> listSchools();
    School add(String name);
}
