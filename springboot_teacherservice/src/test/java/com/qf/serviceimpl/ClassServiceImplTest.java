package com.qf.serviceimpl;

import com.qf.dao.ClassMapper;
import com.qf.entity.Classes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassServiceImplTest {

    @Autowired
    private ClassMapper classMapper;

    @Test
    public void queryClass() throws Exception {
    }

    @Test
    public void insertClasses() throws Exception {
    }

    @Test
    public void queryList() throws Exception {
        List<Classes> classesList = classMapper.selectList(null);
        for (Classes classes : classesList) {
            System.out.println(classes);
        }
    }

}