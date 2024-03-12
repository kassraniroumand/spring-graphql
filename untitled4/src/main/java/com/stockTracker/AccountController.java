package com.stockTracker;

import com.stocktracker.springbootgraphql.models.types.Account;
import com.stocktracker.springbootgraphql.models.types.AccountType;
import com.stocktracker.springbootgraphql.models.types.Customer;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.slf4j.Logger;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class AccountController {
    Logger logger = org.slf4j.LoggerFactory.getLogger(AccountController.class);
    @SchemaMapping
    public Mono<Account> account(Customer customer,
                                 DataFetchingFieldSelectionSet selectionSet,
                                 DataFetchingEnvironment environment
                                 ){
        logger.info("account selectionSet = " + selectionSet.getFields());
        logger.info("account environment = " + environment.getOperationDefinition());
        var type = ThreadLocalRandom.current().nextBoolean() ? "CHECKING" : "SAVING";
        return Mono.just(
                Account.newBuilder()
                        .id(UUID.randomUUID().toString())
                        .accountType(AccountType.valueOf(type))
                        .amount(ThreadLocalRandom.current().nextInt(100, 1000))
                        .build()
        );
    }

}
