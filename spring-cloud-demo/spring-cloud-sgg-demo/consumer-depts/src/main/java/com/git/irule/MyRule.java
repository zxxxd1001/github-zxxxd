package com.git.irule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 没明白啥意思--自定义的负载均衡算法不要放在ComponentScan扫描包下
 * 每个服务调用五次
 */
public class MyRule extends AbstractLoadBalancerRule {
    private AtomicInteger total = new AtomicInteger(0);
    private AtomicInteger currentInteger = new AtomicInteger(0);

    public MyRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                if (total.get() > 4) {
                    total.set(0);
                    currentInteger.set(currentInteger.get()+1);
                    if(currentInteger.get()>=serverCount){
                        currentInteger.set(0);
                    }
                }
                total.set(total.get()+1);

                server = (Server) upList.get(currentInteger.get());
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
