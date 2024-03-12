package com.stockTracker.service;


import com.stockTracker.entity.CustomerEntity;
import com.stockTracker.repository.CustomerRepository;
import com.stockTracker.util.EntityDtoUtil;
import com.stocktracker.springbootgraphql.models.types.Customer;
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

    public Flux<Customer> allCustomers() {
        return customerRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Mono<Customer> customerById(Integer id){
        return customerRepository
                .findById(id)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<Customer> createCustomer(Customer customer){
            return Mono.just(customer)
                    .map(EntityDtoUtil::toEntity)
                    .flatMap(customerRepository::save)
                    .map(EntityDtoUtil::toDto);
    }

    public Mono<Customer> updateCustomer(Integer id, Customer customer){
        return customerRepository
                .findById(id)
                .map(c -> EntityDtoUtil.toEntity(id, customer)) // map to entity
                .flatMap(customerRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<DeleteResponse> deleteCustomer(Integer id){
        return customerRepository.deleteById(id)
                .thenReturn(DeleteResponse.newBuilder().id(String.valueOf(id)).status(Status.SUCCESS).build())
                .onErrorReturn(DeleteResponse.newBuilder().id(String.valueOf(id)).status(Status.FAILURE).build());
    }


}
