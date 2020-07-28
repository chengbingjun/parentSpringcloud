package com.kuang.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author cbjun
 * @create 2019/12/18 15:42
 */
@SpringBootApplication
@EnableEurekaClient //将该服务注册到eureka服务端中，@EnableEurekaClient只能注册到eureka中
//@EnableDiscoveryClient //服务注册，@EnableDiscoveryClient可以注册到多种注册中心中，例如zk、eureka
@EnableCircuitBreaker//添加对熔断机制的支持
public class DeptProvider_hystrix {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_hystrix.class, args);
    }
    //增加一个servlet，这是hystrix监控的必要步骤，表示这个服务被监控了
    @Bean
    public ServletRegistrationBean a(){
       ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
       registrationBean.addUrlMappings("/actuator/hystrix.stream");
       return registrationBean;
    }
}
