package com.stockTracker.service;

import com.stockTracker.repository.CustomerRepository;
import com.stockTracker.util.EntityDtoUtil;
import com.stocktracker.springbootgraphql.models.types.CustomerDto;
import com.stocktracker.springbootgraphql.models.types.CustomerInput;
import com.stocktracker.springbootgraphql.models.types.DeleteResponse;
import com.stocktracker.springbootgraphql.models.types.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<CustomerDto> allCustomers() {
        return customerRepository
                .findAll()
                .map(EntityDtoUtil::convertToDto);
    }

    public Mono<CustomerDto> customerById(String id) {
        return customerRepository
                .findById(Integer.parseInt(id))
                .map(EntityDtoUtil::convertToDto);
    }

    public Mono<CustomerDto> createCustomer(CustomerDto customerDto) {
        return Mono.just(customerDto)
                .map(EntityDtoUtil::convertToEntity)
                .flatMap(customerRepository::save)
                .map(EntityDtoUtil::convertToDto);
    }

    public Mono<CustomerDto> updateCustomer(String id, CustomerInput customerInput) {
        return Mono.just(customerInput)
                .map(dto -> EntityDtoUtil.convertToEntity(Integer.parseInt(id), customerInput))
                .flatMap(customerRepository::save)
                .map(EntityDtoUtil::convertToDto);
    }

    public Mono<DeleteResponse> deleteCustomer(String id) {
        return customerRepository
                .deleteById(Integer.parseInt(id))
                .thenReturn(DeleteResponse.newBuilder().id(id).status(Status.SUCCESS).build())
                .onErrorReturn(DeleteResponse.newBuilder().id(id).status(Status.FAILURE).build());
    }
}
