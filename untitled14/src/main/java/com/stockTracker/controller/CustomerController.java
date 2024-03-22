package com.stockTracker.controller;

import com.stockTracker.service.CustomerService;
import com.stocktracker.springbootgraphql.models.types.CustomerDto;
import com.stocktracker.springbootgraphql.models.types.CustomerInput;
import com.stocktracker.springbootgraphql.models.types.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    public CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public Flux<CustomerDto> customers() {
        return customerService.allCustomers();
    }

    @QueryMapping
    public Mono<CustomerDto> customerById(@Argument String id) {
        return customerService.customerById(id);
    }

    @MutationMapping("createCustomer")
    public Mono<CustomerDto> createCustomer(@Argument CustomerDto customer) {
        return customerService.createCustomer(customer);
    }

    @MutationMapping("updateCustomer")
    public Mono<CustomerDto> updateCustomer(@Argument String id,
                                            @Argument CustomerInput customer) {
        return customerService.updateCustomer(id, customer);
    }


    @MutationMapping("deleteCustomer")
    public Mono<DeleteResponse> deleteCustomer(@Argument String id) {
        return customerService.deleteCustomer(id);
    }







}
