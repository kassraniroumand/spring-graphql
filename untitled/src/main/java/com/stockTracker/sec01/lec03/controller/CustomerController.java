package com.stocktracker.springbootgraphql.sec01.lec03.controller;


import com.stocktracker.springbootgraphql.lec03.types.Customer2;
import com.stocktracker.springbootgraphql.lec03.types.CustomerOrder;
import com.stocktracker.springbootgraphql.sec01.lec03.service.CustomerService;
import com.stocktracker.springbootgraphql.sec01.lec03.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @QueryMapping
    public Flux<Customer> customers2() {
        return customerService.allCustomers();
    }

    @SchemaMapping(
            typeName = "Customer2",
            field = "orders"
    )
    public Flux<CustomerOrder> orders(Customer2 customer) {
        return orderService.orderByCustomerName(customer.getName());
    }


}
