package com.git.zxxxd.service;

import com.git.zxxxd.entity.Depts;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 统一处理DeptClientService这个类中的熔断
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Depts depts) {
                return false;
            }

            @Override
            public Depts findById(Long deptNo) {
                Depts d=new Depts();
                d.setDeptNo(deptNo);
                d.setDeptName("该deptNo没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭");
                d.setDbSource("没有这个数据库");
                return d;
            }

            @Override
            public List findAll() {
              return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
