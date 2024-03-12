package com.stockTracker.controller;

import com.stockTracker.service.CustomerService;
import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.CustomerInput;
import com.stocktracker.springbootgraphql.models.types.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @QueryMapping("customers")
    public Flux<Customer> customers(){
        return customerService.allCustomers();
    }

    @QueryMapping
    public Mono<Customer> customerById(@Argument int id){
        return customerService.customerById(id);
    }

//    @MutationMapping("createCustomer")
//    public Mono<Customer> createCustomer(@Argument CustomerInput CustomerInput){
//        return customerService.createCustomer(CustomerInput);
//    }
//
//    @MutationMapping("updateCustomer")
//    public Mono<Customer> updateCustomer(@Argument Integer id, @Argument("customer") Customer dto){
//        return this.customerService.updateCustomer(id, dto);
//    }

    @MutationMapping
    public Mono<DeleteResponse> deleteCustomer(@Argument Integer id){
        return this.customerService.deleteCustomer(id);
    }






}
