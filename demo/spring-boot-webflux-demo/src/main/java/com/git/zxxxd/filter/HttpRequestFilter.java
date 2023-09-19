package com.git.zxxxd.filter;

import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class HttpRequestFilter implements WebFilter, Ordered {
    /**
     * //当body中没有缓存时，只会执行这一个拦截器， 原因是fileMap中的代码没有执行，所以需要在body为空时构建一个空的缓存
     * DefaultDataBufferFactory defaultDataBufferFactory = new DefaultDataBufferFactory();
     * DefaultDataBuffer defaultDataBuffer = defaultDataBufferFactory.allocateBuffer(0);
     * //构建新数据流， 当body为空时，构建空流
     * Flux<DataBuffer> bodyDataBuffer = exchange.getRequest().getBody().defaultIfEmpty(defaultDataBuffer);
     * return DataBufferUtils.join(bodyDataBuffer).flatMap()
     *
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        String contentType = request.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE);
        HttpMethod method = request.getMethod();
        System.out.println(String.format("handle request body data, filter:[%s], url:[%s] , contentType:[%s]", this.getClass().getName(), path, contentType));

        // 只对=application/json的数据进行重写RequesetBody
        if (MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
            AtomicReference<String> bodyRef = new AtomicReference<>();
            return DataBufferUtils.join(request.getBody()).flatMap(dataBuffer -> {
                CharBuffer charBuffer = StandardCharsets.UTF_8.decode(dataBuffer.asByteBuffer());
//                DataBufferUtils.retain(dataBuffer);
                // 释放掉内存
                DataBufferUtils.release(dataBuffer);
                bodyRef.set(charBuffer.toString());
                String bodyStr = bodyRef.get();
                System.out.println("read request body:\n" + bodyStr);
                Flux<DataBuffer> cachedFlux = Flux.defer(() -> Flux.just(dataBuffer.slice(0, dataBuffer.readableByteCount())));
                //封装request，传给下一级
                ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
                    @Override
                    public Flux<DataBuffer> getBody() {
                        return cachedFlux;
                    }
                };
                return chain.filter(exchange.mutate().request(mutatedRequest).build());
            });
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE;
        return 50;
    }
}
