package com.chajiu.bangbangbe.service;

import com.chajiu.bangbangbe.entity.School;

import java.util.List;

public interface ISchoolService {
    List<School> findAll();

    void addSchool(School school);
    void addSchool(String schoolName);

    void delSchool(String schoolName);
}
