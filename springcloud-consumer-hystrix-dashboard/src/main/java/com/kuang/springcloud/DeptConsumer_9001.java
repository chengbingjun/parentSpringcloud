package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author cbjun
 * @create 2019/12/19 11:44
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_9001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_9001.class,args);
    }

}
