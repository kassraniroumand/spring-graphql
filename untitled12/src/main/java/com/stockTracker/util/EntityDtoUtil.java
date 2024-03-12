package com.stockTracker.util;

import com.stockTracker.entity.CustomerEntity;
import com.stocktracker.springbootgraphql.models.types.Customer;
import com.stocktracker.springbootgraphql.models.types.CustomerInput;

public class EntityDtoUtil {

    public static CustomerEntity toEntity(Integer id, Customer customer) {
        return CustomerEntity
                .create(
                        id,
                        customer.getName(),
                        customer.getAge(),
                        customer.getCity()
                );
    }

    public static CustomerEntity toEntity(Customer customer) {
        return CustomerEntity
                .create(
                        Integer.parseInt(customer.getId()),
                        customer.getName(),
                        customer.getAge(),
                        customer.getCity()
                );
    }


    public static CustomerEntity toEntity(CustomerInput customer) {
        return CustomerEntity
                .create(
                        null,
                        customer.getName(),
                        customer.getAge(),
                        customer.getCity()
                );
    }



    public static Customer toDto(CustomerEntity customerEntity) {
        return Customer
                .newBuilder()
                .id(customerEntity.getId().toString())
                .name(customerEntity.getName())
                .age(customerEntity.getAge())
                .city(customerEntity.getCity())
                .build();
    }

}
