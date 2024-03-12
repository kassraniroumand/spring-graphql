package com.stockTracker.service;

import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.FilterAge;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Filter;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            Customer.newBuilder().id("1").name("sam").age(20).build(),
            Customer.newBuilder().id("2").name("mike").age(30).build(),
            Customer.newBuilder().id("3").name("jane").age(40).build(),
            Customer.newBuilder().id("4").name("lucy").age(50).build()
    );

    public Flux<Customer> allCustomers(){
        return flux;
    }

    public Flux<Customer> findCustomerByFilter(FilterAge filterAge){
        System.out.println("filterAge = " + filterAge);
        Flux<Customer> filter = flux.filter(c ->
                c.getAge() > filterAge.getMin() &&
                        c.getAge() < filterAge.getMax());
        System.out.println("filter = " + filter);
        return  filter;
    }

    public Mono<Customer> findCustomerById(String id){
        return flux.filter(c -> c.getId().equals(id)).next();
    }



}
