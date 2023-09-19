package com.git.zxxxd;

import reactor.core.publisher.Mono;

import java.util.Arrays;

public class TestMono {
    public static void main(String[] args) {
        Mono<Integer[]> just = Mono.just(new Integer[]{1, 2, 3, 5});
        just.subscribe(i->{
            for(Integer y:i){
                System.out.println(y);
            }
        });
    }
}
