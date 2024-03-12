package com.stockTracker.service;

import com.stocktracker.springbootgraphql.models.types.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            Customer.newBuilder().id("1").name("sam").age(20).city("city1").build(),
            Customer.newBuilder().id("2").name("mike").age(30).city("city2").build(),
            Customer.newBuilder().id("3").name("jane").age(40).city("city3").build(),
            Customer.newBuilder().id("4").name("lucy").age(50).city("city4").build()
    );

    public Flux<Customer> allCustomers(){
        return flux;
    }

}
