package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

public interface IClassService {
    Classes queryClass(int id);
    int insertClasses(Classes classes);
    List<Classes> queryList();
}
