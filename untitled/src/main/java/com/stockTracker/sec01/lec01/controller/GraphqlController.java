package com.stockTracker.sec01.lec01.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class GraphqlController {

    @QueryMapping("sayHello")
    public Mono<String> helloWorld() {
        return Mono.just("Hello, World!").delayElement(java.time.Duration.ofSeconds(5));
    }

    @QueryMapping
    public Mono<String> sayHelloTo(@Argument("name") String value) {
        return Mono.fromSupplier(() -> "Hello, " + value + "!").delayElement(java.time.Duration.ofSeconds(5));
    }

}
