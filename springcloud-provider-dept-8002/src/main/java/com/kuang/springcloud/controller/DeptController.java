package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
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
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @PostMapping("/dept/getOne")
    public Dept getDeptById(@RequestBody Long id) {
        return deptService.getDeptById(id);
    }

    @PostMapping("/dept/findAll")
    public List<Dept> findAllDept() {
        return deptService.findAllDept();
    }

    //eureka中的服务发现
    @PostMapping("/dept/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        System.out.println("services--->" + services);
        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println("serviceInstance--->" + serviceInstance.getHost() + "/" +
                    serviceInstance.getPort() + "/" +
                    serviceInstance.getServiceId());
        }
        return discoveryClient;
    }
}
