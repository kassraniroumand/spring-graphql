package com.stockTracker;

import com.stockTracker.service.CustomerService;
import com.stockTracker.service.OrderService;
import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

@Controller
public class GraphqlController {
    Logger logger = Logger.getLogger(GraphqlController.class.getName());

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

        @QueryMapping
        public Flux<Customer> customers() {
            logger.info("controller: customers");
            return customerService.allCustomers();
        }

        @SchemaMapping(typeName = "Customer")
        public Flux<CustomerOrder> orders(Customer customer,  @Argument Integer limit) {
            logger.info("controller: orders for customer: " + customer.getName());
            return orderService.ordersByCustomerName(customer.getName()).take(limit);
        }


}
