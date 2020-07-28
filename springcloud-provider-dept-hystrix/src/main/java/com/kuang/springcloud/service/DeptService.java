package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;

import java.util.List;

/**
 * @Author cbjun
 * @create 2019/12/18 15:20
 */
public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept getDeptById(Long id);

    public List<Dept> findAllDept();
}
