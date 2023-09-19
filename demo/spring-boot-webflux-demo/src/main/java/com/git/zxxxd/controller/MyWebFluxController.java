package com.git.zxxxd.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class MyWebFluxController {

    /**
     * 127.0.0.1:18083/invoice/asdasd?abc=123
     * header test:1
     */
    public Mono<ServerResponse> get(ServerRequest request) {
        Map<String, Object> attributes = request.attributes();
        ServerRequest.Headers headers = request.headers();
        HttpHeaders httpHeaders = headers.asHttpHeaders();
        MultiValueMap<String, String> queryParams = request.queryParams();
        Map<String, String> pathVariables = request.pathVariables();
        System.out.println();
        Map<String, Object> m = new HashMap<>();
        m.put("hello", "word");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(m), Map.class);
    }
}
