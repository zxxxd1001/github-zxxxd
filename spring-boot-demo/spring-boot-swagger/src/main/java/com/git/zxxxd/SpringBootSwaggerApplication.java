package com.git.zxxxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http://c.biancheng.net/view/5532.html
 */
@SpringBootApplication
public class SpringBootSwaggerApplication {

    /**
     * Swagger 是一个规范且完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。
     * <p>
     * Swagger 的目标是对 REST API 定义一个标准且和语言无关的接口，
     * 可以让人和计算机拥有无须访问源码、文档或网络流量监测就可以发现和理解服务的能力。
     * 当通过 Swagger 进行正确定义，用户可以理解远程服务并使用最少实现逻辑与远程服务进行交互。
     * 与为底层编程所实现的接口类似，Swagger 消除了调用服务时可能会有的猜测。
     * <p>
     * Swagger 的优势
     * 支持 API 自动生成同步的在线文档：
     * 使用 Swagger 后可以直接通过代码生成文档，不再需要自己手动编写接口文档了，对程序员来说非常方便，可以节约写文档的时间去学习新技术。
     * <p>
     * 提供 Web 页面在线测试 API：光有文档还不够，Swagger 生成的文档还支持在线测试。
     * 参数和格式都定好了，直接在界面上输入参数对应的值即可在线测试接口。
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwaggerApplication.class, args);
    }

}
