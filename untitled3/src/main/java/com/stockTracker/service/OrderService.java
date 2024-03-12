package com.stockTracker.service;

import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.CustomerOrder;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(OrderService.class);

    private final Map<String, List<CustomerOrder>> map = Map.of(
            "sam", List.of(
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("sam-product-1").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("sam-product-2").build()
            ),
            "mike", List.of(
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-1").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-2").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-3").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-4").build(),
                    CustomerOrder.newBuilder().id(String.valueOf(UUID.randomUUID())).description("mike-product-5").build()
            )
    );

    public Flux<CustomerOrder> ordersByCustomerName(String name) {
        logger.info("service: orders for customer: " + name);
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList()));
    }

    public Flux<List<CustomerOrder>> ordersByCustomerNameByLists(List<String> lsts) {
        logger.info("service: orders for customer: " + lsts);
        return Flux
                .fromIterable(lsts)
                .map(name -> map.getOrDefault(name, Collections.emptyList()));
    }

    public Flux<List<CustomerOrder>> ordersByCustomerNameByLists2(List<String> lsts) {
        logger.info("service: orders for customer: " + lsts);
        return Flux
                .fromIterable(lsts)
                .flatMapSequential(n -> fetchOrder(n).defaultIfEmpty(Collections.emptyList()));
    }

    private Mono<List<CustomerOrder>> fetchOrder(String name) {
        return Mono
                .justOrEmpty(map.get(name))
                .delayElement(Duration
                        .ofMillis(ThreadLocalRandom.current().nextInt(0, 500)));
    }


    public Mono<Map<Customer, List<CustomerOrder>>> fetchOrderByMap(List<Customer> customers) {
        return  Flux
                .fromIterable(customers)
                .map(c -> Tuples.of(c, map.getOrDefault(c.getName(), Collections.emptyList()))).collectMap(
                        Tuple2::getT1, Tuple2::getT2
                );
    }


}