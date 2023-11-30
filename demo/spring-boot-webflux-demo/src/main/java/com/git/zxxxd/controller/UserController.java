package com.git.zxxxd.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserController {
    private static Mono<List<User>> list;

    public UserController() {
        List<User> users = new ArrayList<>();
        users.add(new User(123, "张三", 18));
        users.add(new User(234, "王五", 28));
        users.add(new User(334, "赵四", 38));
        users.add(new User(434, "李四", 48));
        list = Mono.just(users);
    }

    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        if (StringUtils.isEmpty(id)) {
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("缺少查询参数", String.class);
        }
        Mono<List<User>> listMono = list.flatMap(user -> {
            List<User> users = new ArrayList<>();
            for (User u : user) {
                if (id.equals(u.getId().toString())) {
                    users.add(u);
                }
            }
            return Mono.just(users);
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listMono, List.class);
    }

    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list, List.class);
    }

    public Mono<ServerResponse> addUser(ServerRequest serverRequest) {
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        Mono<List<User>> listMono = list.zipWith(userMono, (a, b) -> {
            b.setId(new Random().nextInt());
            a.add(b);
            return a;
        });
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listMono, List.class);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        String id = serverRequest.queryParam("id").orElse("");
        list.subscribe(user->{
            for (int i=0;i<user.size();i++) {
                User u = user.get(i);
                if (id.equals(u.getId().toString())) {
                    user.remove(i);
                }
            }
        });
        System.out.println("==============");
        Mono<String> mono = Mono.just("Hello")
                .switchIfEmpty(Mono.just("World"));

        mono.subscribe(System.out::println);
        System.out.println("==============");

        Mono<String> monos = Mono.just("Hello").then(Mono.just("World"));

        monos.subscribe(System.out::println);
        System.out.println("==============");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list,List.class);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer age;
}
