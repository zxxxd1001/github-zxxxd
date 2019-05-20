package com.git.zxxxd.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    @Bean
    public IRule myRule() {
        /**
         * 配置负载均衡算法
         */
//        return new RoundRobinRule(); //轮询 默认
//        return new RandomRule(); //随机
//        return new AvailabilityFilteringRule();//过滤多次访问故障处于断路器跳闸的服务，还有并发的连接数量超过阈值的服务，对剩余的服务列表按照轮询策略进行访问。
//        return new WeightedResponseTimeRule();//根据平均响应时间计算所有服务的权重，响应时间越快服务选中几率越高。刚启动时如果计算信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule。
        return new RetryRule();//根据RoundRobinRule获取服务，当服务获取失败则在指定时间内会进行重试，获取可用的服务
//        return new BestAvailableRule();//过滤多次访问故障处于断路器跳闸的服务，然后选者一个并发量小的服务
    }
}
