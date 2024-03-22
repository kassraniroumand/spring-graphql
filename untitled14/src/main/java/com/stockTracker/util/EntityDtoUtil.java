package com.stockTracker.util;


import com.stockTracker.entity.Customer;
import com.stocktracker.springbootgraphql.models.types.CustomerDto;
import com.stocktracker.springbootgraphql.models.types.CustomerInput;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoUtil {


    public static Customer convertToEntity(CustomerDto customerDto) {
        return Customer.create(
                null,
                customerDto.getName(),
                customerDto.getAge(),
                customerDto.getCity()
        );
    }

    public static Customer convertToEntity(Integer id, CustomerInput customerDto) {
        return Customer.create(
                id,
                customerDto.getName(),
                customerDto.getAge(),
                customerDto.getCity()
        );
    }

    public  static CustomerDto convertToDto(Customer customer) {
        return CustomerDto.newBuilder()
                .id(customer.getId().toString())
                .name(customer.getName())
                .age(customer.getAge())
                .city(customer.getCity())
                .build();
    }


}
