package com.stockTracker.service;

import com.stocktracker.springbootgraphql.models.types.CustomerOrder;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(OrderService.class);

    private final Map<String, List<CustomerOrder>> map = Map.of(
            "sam", List.of(
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("sam-product-1").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("sam-product-2").build()
            )
//            ,
//            "mike", List.of(
//                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-1").build(),
//                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-2").build(),
//                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-3").build(),
//                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-4").build(),
//                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-5").build()
//            )
    );

    public Flux<CustomerOrder> ordersByCustomerName(String name){
        logger.info("service: orders for customer: " + name);
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList())).doOnNext(o -> print("order for : " + name));
    }

    private void print(String name){
        System.out.println(LocalDateTime.now() + " : " + name);
    }

}