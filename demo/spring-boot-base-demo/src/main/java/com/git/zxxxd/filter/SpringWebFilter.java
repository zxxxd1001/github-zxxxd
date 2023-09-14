//package com.git.zxxxd.filter;
//
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.nio.CharBuffer;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class SpringWebFilter implements WebFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        String contentType = request.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE);
//        if (MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
//            return DataBufferUtils.join(request.getBody()).flatMap(dataBuffer -> {
//                CharBuffer charBuffer = StandardCharsets.UTF_8.decode(dataBuffer.asByteBuffer());
////                DataBufferUtils.retain(dataBuffer);
//                System.out.println(charBuffer.toString());
//                Flux<DataBuffer> cachedFlux = Flux.defer(() -> Flux.just(dataBuffer.slice(0, dataBuffer.readableByteCount())));
//                //封装request，传给下一级
//                ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
//                    @Override
//                    public Flux<DataBuffer> getBody() {
//                        return cachedFlux;
//                    }
//                };
//                return chain.filter(exchange.mutate().request(mutatedRequest).build());
//            });
//        }
//        return chain.filter(exchange);
//    }
//}
