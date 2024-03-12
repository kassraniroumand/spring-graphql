package com.stockTracker.util;

import com.stockTracker.entity.CustomerEntity;
import com.stocktracker.springbootgraphql.models.types.Customer;

public class EntityDtoUtil {

    public static CustomerEntity toEntity(Customer customer) {
        return CustomerEntity
                .create(
                        Integer.parseInt(customer.getId()),
                        customer.getName(),
                        customer.getAge(),
                        customer.getCity()
                );
    }

    public static Customer toDto(CustomerEntity customerEntity) {
        return Customer
                .create(
                        customerEntity.getId().toString(),
                        customerEntity.getName(),
                        customerEntity.getAge(),
                        customerEntity.getCity()
                );
    }

}
