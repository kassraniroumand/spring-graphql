package com.stocktracker.springbootgraphql.sec01.lec03.service;

import com.stocktracker.springbootgraphql.lec02.types.AgeRangeFilter;
import com.stocktracker.springbootgraphql.lec02.types.Customer;
import com.stocktracker.springbootgraphql.lec03.types.Customer2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CustomerService implements ICustomerService {

    Flux<Customer2> flux = Flux.just(
            Customer2.newBuilder().id("1").age(201).name("kasra1").city("city").build(),
            Customer2.newBuilder().id("2").age(202).name("kasra2").city("city").build(),
            Customer2.newBuilder().id("3").age(203).name("kasra3").city("city").build(),
            Customer2.newBuilder().id("4").age(204).name("kasra4").city("city").build(),
            Customer2.newBuilder().id("5").age(205).name("kasra5").city("city").build()
    );


    @Override
    public Flux<Customer2> allCustomers() {
        return flux;
    }

    @Override
    public Mono<Customer2> customerById(String id) {
        return flux.filter(customer -> customer.getId().equals(id)).next();
    }

    @Override
    public Flux<Customer2> customerNameContains(String name) {
        return flux.filter(customer -> customer.getName().contains(name));
    }

    @Override
    public Flux<Customer2> customerByAgeRange(AgeRangeFilter ageRangeFilter) {
        return flux.filter(customer -> customer.getAge() >= ageRangeFilter.getMinAge() && customer.getAge() <= ageRangeFilter.getMaxAge());
    }
}
