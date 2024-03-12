package com.stockTracker;


import com.stockTracker.service.CustomerService;
import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.FilterAge;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {
    Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @QueryMapping("customers")
    public Flux<Customer> allCustomers(
            DataFetchingFieldSelectionSet selectionSet
    ){
        logger.info("allCustomers selectionSet = " + selectionSet.getFields());
        return customerService.allCustomers();
    }

    @QueryMapping
    public Flux<Customer> findCustomerByFilter(
            @Argument  FilterAge filter
    ){

       return this
               .customerService
               .findCustomerByFilter(filter);
    }

    @QueryMapping
    public Mono<Customer> findCustomerById(
            @Argument String id
    ){
       return this
               .customerService
               .findCustomerById(id);
    }

}
