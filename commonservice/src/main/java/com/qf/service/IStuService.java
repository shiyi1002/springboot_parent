package com.qf.service;

import com.qf.entity.Student;
import com.qf.entity.StudentVo;

import java.util.List;

public interface IStuService {
    List<StudentVo> queryAll();
    int insert(Student student);
    int update(Student student);
    Student selectOne(int id);
    int delete(int id);
}
