package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author cbjun
 * @create 2019/12/19 11:33
 */
@RestController
public class DeptController {

    @Autowired
    private RestTemplate restTemplate; //相当于是spring帮你封装好的httpclient工具类

    //通过服务提供者提供的服务的项目名(springcloud-provider-dept-8001项目的application名称)，找到相应的服务，访问相应接口
    private String url_start = "http://springcloud-provider-dept";

    @PostMapping("/consumer/add")
    public Boolean add(@RequestBody Dept dept){
        return restTemplate.postForObject(url_start+"/dept/add",dept,Boolean.class);
    }

    @PostMapping("/consumer/getOne")
    public Dept getDeptById(@RequestBody Long id){
        return restTemplate.postForObject(url_start+"/dept/getOne",id,Dept.class);
    }

    @PostMapping("/consumer/findAll")
    public List<Dept> findAllDept(){
        return restTemplate.postForObject(url_start+"/dept/findAll",null,List.class);
    }
}
