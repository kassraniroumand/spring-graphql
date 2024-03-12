package com.stockTracker.sec01.lec03.service;

import com.stocktracker.springbootgraphql.lec02.types.AgeRangeFilter;
import com.stocktracker.springbootgraphql.lec02.types.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ICustomerService  {

//    customers: [Customer]!
//    customerById(id: ID!): Customer
//    customerNameContains(name: String!): [Customer]
    Flux<Customer> allCustomers();
    Mono<Customer> customerById(String id);
    Flux<Customer> customerNameContains(String name);
    Flux<Customer> customerByAgeRange(AgeRangeFilter ageRangeFilter);

}
