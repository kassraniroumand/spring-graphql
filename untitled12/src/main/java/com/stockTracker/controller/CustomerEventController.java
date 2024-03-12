package com.stockTracker.controller;

import com.stockTracker.service.CustomerEventService;
import com.stocktracker.springbootgraphql.models.types.CustomerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class CustomerEventController {

    @Autowired
    private CustomerEventService service;

    @SubscriptionMapping
    public Flux<CustomerEvent> customerEvents(){
        return this.service.subscribe();
    }

}