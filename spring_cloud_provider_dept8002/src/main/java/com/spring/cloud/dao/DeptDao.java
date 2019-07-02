package com.spring.cloud.dao;

import com.spring.cloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author GongXings
 * @createTime 30 14:48
 * @description
 */
@Mapper
public interface DeptDao {

    boolean addDept(Dept deptEntity);


    Dept findById(Long deptNo);


    List<Dept> findAll();

}