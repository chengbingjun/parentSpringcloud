package com.kuang.springcloud.service;

import com.kuang.springcloud.dao.DeptDao;
import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author cbjun
 * @create 2019/12/18 15:21
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept getDeptById(Long id) {
        return deptDao.getDeptById(id);
    }

    @Override
    public List<Dept> findAllDept() {
        return deptDao.findAllDept();
    }
}
