package com.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.entity.Dept;
import com.spring.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @RequestMapping(value = "/dept/findById/{deptNo}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        System.out.println(deptNo+"=======================");
        Dept deptEntity = deptService.findById(deptNo);
        if(null ==deptEntity){
            throw  new RuntimeException("该deptNo没有对应的信息"+deptNo);
        }
        return  deptEntity;
    }

    
}