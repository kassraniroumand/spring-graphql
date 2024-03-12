package com.stockTracker;


import com.stockTracker.service.CustomerService;
import com.stockTracker.service.OrderService;
import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private OrderService orderService;

    // @QueryMapping
    @SchemaMapping(typeName = "Query")
    public Flux<Customer> customers(){
        return this.service.allCustomers();
    }

    @SchemaMapping(typeName = "Customer")
    public Flux<CustomerOrder> orders(Customer customer, @Argument Integer limit){
        System.out.println("Orders method invoked for " + customer.getName());
        return this.orderService.ordersByCustomerName(customer.getName())
                .take(limit);
    }

}