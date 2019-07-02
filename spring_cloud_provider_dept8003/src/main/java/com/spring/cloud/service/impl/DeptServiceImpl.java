package com.spring.cloud.service.impl;

import com.spring.cloud.dao.DeptDao;
import com.spring.cloud.entity.Dept;
import com.spring.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    DeptDao deptDao;
    @Override
    public boolean addDept(Dept deptEntity) {
        return   deptDao.addDept(deptEntity);
    }

    @Override
    public Dept findById(Long deptNo) {
        return  deptDao.findById(deptNo);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
