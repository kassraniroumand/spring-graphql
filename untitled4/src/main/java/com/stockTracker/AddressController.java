package com.stockTracker;

import com.stocktracker.springbootgraphql.models.types.Address;
import com.stocktracker.springbootgraphql.models.types.Customer;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.slf4j.Logger;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import javax.xml.crypto.Data;

@Controller
public class AddressController {
    Logger logger = org.slf4j.LoggerFactory.getLogger(AddressController.class);
    @SchemaMapping
    public Mono<Address> address(Customer customer, DataFetchingFieldSelectionSet selectionSet){
        logger.info("address selectionSet = " + selectionSet.getFields());
        return Mono.just(
                Address.newBuilder()
                        .street("New York")
                        .city("10001")
                        .build()
        );
    }

}
