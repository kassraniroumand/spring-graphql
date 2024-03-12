package com.stockTracker.service;

import com.stocktracker.springbootgraphql.models.types.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            Customer.newBuilder().id(String.valueOf(UUID.randomUUID())).name("sam").build(),
            Customer.newBuilder().id(String.valueOf(UUID.randomUUID())).name("tom").build(),
            Customer.newBuilder().id(String.valueOf(UUID.randomUUID())).name("jerry").build(),
            Customer.newBuilder().id(String.valueOf(UUID.randomUUID())).name("spike").build()
    );

    public Flux<Customer> allCustomers(){
        return flux;
    }

}