package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author cbjun
 * @create 2020/3/18 15:14
 */
//服务降级
@Component
public class DeptServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptServiceClient() {
            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }

            @Override
            public Dept getDeptById(Long id) {
                Dept dept = new Dept();
                dept.setDeptNo(id);
                dept.setDataSource("没相关信息02");
                dept.setDeptName("没相关信息02");
                return dept;
            }

            @Override
            public List<Dept> findAllDept() {
                return null;
            }
        };
    }
}
