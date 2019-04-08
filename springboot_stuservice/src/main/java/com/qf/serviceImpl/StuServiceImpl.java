package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.entity.StudentVo;
import com.qf.service.IClassService;
import com.qf.service.IStuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Service
public class StuServiceImpl implements IStuService {
    @Autowired
    private StuMapper stuMapper;
    @Reference
    private IClassService classService;
    @Override
    public List<StudentVo> queryAll() {

        List<StudentVo> studentVoList=new ArrayList<>();
        List<Student> studentList=stuMapper.selectList(null);
        System.out.println(studentList.size());
        List<Classes> classesList = classService.queryList();
        System.out.println(classesList.size());

        for (Student student : studentList) {
            for (Classes classes : classesList) {
                if(student.getClassesId()==classes.getId()){
                    StudentVo studentVo=new StudentVo();
                    BeanUtils.copyProperties(student,studentVo);
                    studentVo.setCname(classes.getCname());
                    System.out.println(studentVo);
                    studentVoList.add(studentVo);
                }
            }
        }
        return studentVoList;
    }

    @Override
    public int insert(Student student) {
        return stuMapper.insert(student);
    }

    @Override
    public int update(Student student) {
        return stuMapper.updateById(student);
    }

    @Override
    public Student selectOne(int id) {
        return stuMapper.selectById(id);
    }

    @Override
    public int delete(int id) {
        return stuMapper.deleteById(id);
    }
}
