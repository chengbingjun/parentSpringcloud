package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cbjun
 * @create 2019/12/18 15:23
 */
//服务熔断
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/getOne")
    @HystrixCommand(fallbackMethod = "getDeptByIdHystrix")//如果当前方法失败，调用备选方法
    public Dept getDeptById(@RequestBody Long id) {
        Dept dept = deptService.getDeptById(id);
        if(dept == null){
            //运行时异常，不用throw
            throw new RuntimeException("用户信息不存在");
        }
        return dept;
    }

    //备选方法
    public Dept getDeptByIdHystrix(@RequestBody Long id) {
        Dept dept = new Dept();
        dept.setDeptNo(id);
        dept.setDataSource("没相关信息01");
        dept.setDeptName("没相关信息01");
        return dept;
    }
}
