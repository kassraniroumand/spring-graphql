package com.stockTracker.config;

import com.stockTracker.service.CustomerOrderDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class DataFetcherWiringConfig {

    @Autowired
    private CustomerOrderDataFetcher dataFetcher;

    @Bean
    public RuntimeWiringConfigurer configurer(){
        return c -> c.type("Query", b -> b.dataFetcher("customers", dataFetcher));
    }

}
