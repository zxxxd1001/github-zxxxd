package com.git.zxxxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private WebClient webClient;

    /**
     * 127.0.0.1:18083/hello
     * {
     * "asd":"Asd"
     * }
     */
    @PostMapping("/hello")
    public Map<String, Object> hello(ServerWebExchange exchange, @RequestBody Map<String, Object> map) {
        Map<String, Object> stringObjectMap = Optional.ofNullable(map)
                .map(m -> {
                    m.put("hello", "world");
                    return m;
                }).orElseGet(() -> new HashMap<>());
//        exchange.getResponse().setStatusCode(HttpStatus.FOUND);
        Integer i=1/0;
        return stringObjectMap;
    }

    /**
     * 127.0.0.1:18083/123
     */
    @GetMapping("/{id}")
    public Mono<Map> getById(@PathVariable long id) {
        //retrieve获取响应主体并对其进行解码的最简单方法
        Mono<Map> mapMono = webClient.get().uri("http://127.0.0.1:18083/invoice/{orderId}?abc=123", "88")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError,
//                        response -> response.bodyToMono(String.class)
//                                .flatMap(error -> Mono.error(new RuntimeException(error)))
//                )
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.just(new RuntimeException("404")))
                .bodyToMono(Map.class);
//                .onErrorReturn(new HashMap());

        //exchange提供更多的控制retrieve
        /**
         * 请注意（与不同retrieve()），对于exchange()，没有4xx和5xx响应的自动错误信号。您必须检查状态码并决定如何进行。
         * 与相比retrieve()，当使用时exchange()，应用程序有责任使用任何响应内容，而不管情况如何（成功，错误，意外数据等）,否则会导致内存泄漏.
         */
        Map<String, Object> req = new HashMap<>();
        req.put("asd", "Asd");
        Mono<ResponseEntity<Map>> responseEntityMono = webClient.post().uri("http://127.0.0.1:18083/hello")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(req), Map.class)
                .exchange()
                .flatMap(response -> response.toEntity(Map.class));

        return mapMono.zipWith(Mono.just(id), (a, b) -> {
            a.put("id", b);
            return a;
        }).zipWith(responseEntityMono, (a, b) -> {
            a.put("/hello", b.getBody());
            return a;
        });
    }
}
