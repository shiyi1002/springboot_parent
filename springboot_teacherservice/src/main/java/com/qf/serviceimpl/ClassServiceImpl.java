package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClassMapper;
import com.qf.entity.Classes;
import com.qf.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService{
    @Autowired
    private ClassMapper classMapper;
    @Override
    public Classes queryClass(int id) {
        return classMapper.selectById(id);
    }

    @Override
    public int insertClasses(Classes classes) {
        return classMapper.insert(classes);
    }

    @Override
    public List<Classes> queryList() {
        return classMapper.selectList(null);
    }
}
