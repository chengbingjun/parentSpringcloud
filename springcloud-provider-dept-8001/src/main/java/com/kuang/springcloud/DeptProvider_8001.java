package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author cbjun
 * @create 2019/12/18 15:42
 */
@SpringBootApplication
@EnableEurekaClient //将该服务注册到eureka服务端中，@EnableEurekaClient只能注册到eureka中
//@EnableDiscoveryClient //服务注册，@EnableDiscoveryClient可以注册到多种注册中心中，例如zk、eureka，
public class DeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class, args);
    }
}
