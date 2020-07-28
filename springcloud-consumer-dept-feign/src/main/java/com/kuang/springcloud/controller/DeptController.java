package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cbjun
 * @create 2019/12/19 11:33
 */
@RestController
public class DeptController {

    @Autowired
    private DeptServiceClient deptServiceClient;

    @PostMapping("/consumer/add")
    public Boolean add(@RequestBody Dept dept){
        return deptServiceClient.addDept(dept);
    }

    @PostMapping("/consumer/getOne")
    public Dept getDeptById(@RequestBody Long id){
        return deptServiceClient.getDeptById(id);
    }

    @PostMapping("/consumer/findAll")
    public List<Dept> findAllDept(){
        return deptServiceClient.findAllDept();
    }
}
