package com.stockTracker.sec01.lec02.controller;

import com.stocktracker.springbootgraphql.lec02.types.AgeRangeFilter;
import com.stocktracker.springbootgraphql.sec01.lec02.service.CustomerService;
import com.stocktracker.springbootgraphql.lec02.types.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService.allCustomers();
    }

    @QueryMapping("customerNameContains")
    public Flux<Customer> customerNameContains(@Argument String name) {
        return customerService.customerNameContains(name);
    }

    @QueryMapping
    public Mono<Customer> customerById(@Argument String id) {
        return customerService.customerById(id);
    }

    @QueryMapping("customerByAgeRange")
    public Flux<Customer> customerByAgeRange(@Argument AgeRangeFilter filter) {
        return customerService.customerByAgeRange(filter);
    }

}
