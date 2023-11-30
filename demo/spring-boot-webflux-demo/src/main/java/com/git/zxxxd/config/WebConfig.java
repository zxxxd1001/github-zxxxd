package com.git.zxxxd.config;

import com.git.zxxxd.controller.MyWebFluxController;
import com.git.zxxxd.controller.UserController;
import com.git.zxxxd.handler.GlobalResponseBodyResultHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @EnableWebFlux 要求 Spring 从 WebFluxConfigurationSupport 引入 Spring WebFlux 配置。
 * 如果你的依赖中引入了 spring-boot-starter-webflux，Spring WebFlux 将自动配置，不需要添加该注解。
 * <p>
 * 但如果你只使用 Spring WebFlux 而没有使用 Spring Boot，
 * 这是需要添加 @EnableWebFlux 启动 Spring WebFlux 自动化配置。
 */
@Configuration
//@EnableWebFlux
//public class WebConfig implements WebFluxConfigurer {
public class WebConfig {

    @Bean
    public WebClient webClient() {
//        HttpClient httpClient = HttpClient.create();
//        ClientHttpConnector connector = new JettyClientHttpConnector(httpClient, resourceFactory());
//        return WebClient.builder().clientConnector(connector).build();
        return WebClient.builder().build();
    }

    @Bean
    public MyWebFluxController myWebFluxController() {
        return new MyWebFluxController();
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(MyWebFluxController myWebFluxController) {
        return RouterFunctions.route()
                .GET("/invoice/{orderId}", RequestPredicates.accept(MediaType.APPLICATION_JSON), myWebFluxController::get)
                .build();
    }

    @Bean
    public GlobalResponseBodyResultHandler responseWrapper(ServerCodecConfigurer serverCodecConfigurer,
                                                           RequestedContentTypeResolver requestedContentTypeResolver) {
        return new GlobalResponseBodyResultHandler(serverCodecConfigurer.getWriters(), requestedContentTypeResolver);
    }

    @Bean
    public UserController userController() {
        return new UserController();
    }

    @Bean
    public RouterFunction<ServerResponse> userRouterFunction(UserController userController) {
//        return RouterFunctions.nest(RequestPredicates.path("/user"),
//                RouterFunctions.route(RequestPredicates.GET("/getAllUser"), userController::getAllUsers)
//                        .andRoute(RequestPredicates.POST("/addUser"), userController::addUser)
//                        .andRoute(RequestPredicates.DELETE("/{userId}"), userController::deleteUser));
        return RouterFunctions.nest(RequestPredicates.path("/user"),
                RouterFunctions.route()
                        .GET("/getUserById/{id}", userController::getUserById)
                        .GET("/getAllUser", userController::getAllUsers)
                        .POST("/addUser", RequestPredicates.accept(MediaType.APPLICATION_JSON), userController::addUser)
                        .DELETE("/deleteUser", userController::deleteUser)
                        .build()
        );
    }
}
