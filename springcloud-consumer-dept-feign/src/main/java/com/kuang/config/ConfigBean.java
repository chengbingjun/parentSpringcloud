package com.kuang.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author cbjun
 * @create 2019/12/19 11:31
 */
@Configuration
public class ConfigBean {

    /**
     * 可以自定义负载均衡策略
     * @return
     */
    @Bean
    public IRule myIRule(){

//        return new RoundRobinRule();//轮询
        return new RandomRule();//随机
    }

}
