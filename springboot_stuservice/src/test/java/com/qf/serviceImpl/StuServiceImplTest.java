package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.dao.StuMapper;
import com.qf.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuServiceImplTest {

    @Autowired
    private StuMapper stuMapper;


    @Test
    public void queryAll() throws Exception {
        List<Student> studentList = stuMapper.selectList(null);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void insert() throws Exception {
    }

}