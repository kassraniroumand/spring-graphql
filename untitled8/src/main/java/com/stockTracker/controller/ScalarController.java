package com.stockTracker.controller;

import com.stocktracker.springbootgraphql.models.types.AllTypes;
import com.stocktracker.springbootgraphql.models.types.Car;
import com.stocktracker.springbootgraphql.models.types.Product;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Controller
public class ScalarController {

    @QueryMapping("get")
    public Mono<AllTypes> getTypes() {
        AllTypes allTypes = AllTypes
                .newBuilder()
                .car(Car.BMW)
                .build();
        return Mono.just(allTypes);
    }

    @QueryMapping("products")
    public Flux<Product> products() {

        Product product1 = Product
                .newBuilder()
                .name("Product 1")
                .attributes(
                    Map.of(
                        "key1", "value1",
                        "key2", "value2"
                    ))
                .build();

        Product product2 = Product
                .newBuilder()
                .name("Product 2")
                .attributes(
                        Map.of(
                                "key 3", "value3",
                                "key 4", "value4"
                        ))
                .build();
        return Flux.just(product1, product2);
    }



}
