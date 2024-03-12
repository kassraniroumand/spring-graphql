package com.stockTracker.service;

import com.stockTracker.dto.CustomerWithOrder;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.function.UnaryOperator;

@Service
public class CustomerOrderDataFetcher {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    public Flux<CustomerWithOrder> customerOrders(DataFetchingFieldSelectionSet selectionSet){

        var includeOrders = selectionSet.contains("orders");
        System.out.println(includeOrders);

        return this
                .customerService
                .allCustomers()
                .map(c->CustomerWithOrder.create(
                        Integer.parseInt(c.getId()),
                        c.getName(),
                        c.getAge(),
                        c.getCity(),
                        Collections.emptyList()
                ))
                .transform(this.updateOrdersTransformer(includeOrders));
    }

    private UnaryOperator<Flux<CustomerWithOrder>> updateOrdersTransformer(boolean includeOrders){
        return includeOrders ? f -> f.flatMap(this::fetchOrders) : f -> f;
    }

    private Mono<CustomerWithOrder> fetchOrders(CustomerWithOrder customerWithOrder){
        return this.orderService.ordersByCustomerName(customerWithOrder.getName())
                .collectList()
                .doOnNext(customerWithOrder::setOrders)
                .thenReturn(customerWithOrder);
    }

}
