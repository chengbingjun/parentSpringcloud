package com.kuang.springcloud.dao;

import com.kuang.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author cbjun
 * @create 2019/12/18 15:10
 */
@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept getDeptById(Long id);

    public List<Dept> findAllDept();
}
