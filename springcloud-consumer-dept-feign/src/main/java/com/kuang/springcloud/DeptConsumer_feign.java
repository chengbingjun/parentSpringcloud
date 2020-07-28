package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author cbjun
 * @create 2019/12/19 11:44
 */
@SpringBootApplication
@EnableEurekaClient
//加上包路径是为了能在ioc中添加带有@FeignClient注解的bean（在api项目中）
@EnableFeignClients(basePackages = {"com.kuang.springcloud"})
public class DeptConsumer_feign {

    @Bean
    @LoadBalanced //负载均衡注解，ribbon是进程式LB：在客户端发送请求的时候进行负载均衡，确定将请求发送到哪个服务端
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign.class,args);
    }

}
