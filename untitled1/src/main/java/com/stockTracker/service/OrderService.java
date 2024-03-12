package com.stockTracker.service;

import com.stocktracker.springbootgraphql.models.types.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    private final Map<String, List<CustomerOrder>> map = Map.of(
            "sam", List.of(
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("sam-product-1").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("sam-product-2").build()
            ),
            "tom", List.of(
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("tom-product-1").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("tom-product-2").build()
            )
    );

    public Flux<CustomerOrder> ordersByCustomerName(String name){
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList()));
    }

}
