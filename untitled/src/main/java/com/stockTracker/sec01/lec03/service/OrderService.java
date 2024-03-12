package com.stocktracker.springbootgraphql.sec01.lec03.service;


import com.stocktracker.springbootgraphql.lec03.types.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final Map<String, List<CustomerOrder>> map = Map.of(
            "kassra", List.of(
                    CustomerOrder.newBuilder().id("1").description("desc1").build(),
                    CustomerOrder.newBuilder().id("2").description("desc2").build()
            ),
            "mike", List.of(
                    CustomerOrder.newBuilder().id("3").description("desc3").build(),
                    CustomerOrder.newBuilder().id("4").description("desc4").build()
            ));

    public Flux<CustomerOrder> orderByCustomerName(String name) {
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList()));
    }

}
