package com.stockTracker.repository;

import com.stockTracker.entity.CustomerEntity;
import com.stocktracker.springbootgraphql.models.types.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<CustomerEntity, Integer> {
}