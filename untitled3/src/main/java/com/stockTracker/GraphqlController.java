package com.stockTracker;

import com.stockTracker.service.CustomerService;
import com.stockTracker.service.OrderService;
import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

//        @BatchMapping(typeName = "Customer")
//        public Flux<List<CustomerOrder>> orders(List<Customer> list) {
//            logger.info("controller: orders for customer: " + list);
//            List<String> lists = list.stream().map(Customer::getName).collect(Collectors.toList());
//            return orderService.ordersByCustomerNameByLists2(lists);
//        }

    @BatchMapping(typeName = "Customer")
    public Mono<Map<Customer, List<CustomerOrder>>> orders(List<Customer> list) {
        logger.info("controller: orders for customer: " + list);
//          List<String> lists = list.stream().map(Customer::getName).collect(Collectors.toList());
        return orderService.fetchOrderByMap(list);
    }


}
