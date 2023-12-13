package com.git.zxxxd;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestThen {
    public static void main(String[] args) {
        Mono<String> then = Mono.just("Hello").then(Mono.just("World"));
        then.subscribe(System.out::println);

        Mono<String> then1 = Flux.just("Hello").then(Mono.just("World"));
        then1.subscribe(System.out::println);
    }
}
