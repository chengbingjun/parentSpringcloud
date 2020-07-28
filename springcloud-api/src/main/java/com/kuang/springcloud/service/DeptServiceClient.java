package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @Author cbjun
 * @create 2020/3/16 10:28
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptServiceClient {

    @PostMapping("/dept/add")
    public Boolean addDept(@RequestBody Dept dept);

    @PostMapping("/dept/getOne")
    public Dept getDeptById(@RequestBody Long id);

    @PostMapping("/dept/findAll")
    public List<Dept> findAllDept();
}
