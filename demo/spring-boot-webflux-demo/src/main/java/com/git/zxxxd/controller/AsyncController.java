package com.git.zxxxd.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AsyncController {

    //text/event-stream 是服务器向浏览器推送消息的一种方案，这种方案和我们所熟知的 WebSocket 有一些差别。
    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        Flux<String> flux = Flux.fromArray(new String[]{"小黑", "小胖", "小六", "一鑫"}).map(s -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "二班：" + s;
        });
        return flux;
    }

}
