package com.kuang.springcloud.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @Author cbjun
 * @create 2019/12/18 11:12
 */
@Data
@NoArgsConstructor
public class Dept implements Serializable {

    private Long deptNo;

    private String deptName;

    private String dataSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
