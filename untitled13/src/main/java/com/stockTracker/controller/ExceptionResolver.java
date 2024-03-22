package com.stockTracker.controller;


import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ExceptionResolver implements DataFetcherExceptionResolver {
    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable exception, DataFetchingEnvironment environment) {
        return Mono.just(
                List.of(
                        GraphqlErrorBuilder
                                .newError(environment)
                                .message(exception.getMessage())
                                .errorType(ErrorType.INTERNAL_ERROR)
                                .extensions(Map.of(
                                        "CustomID", 123,
                                        "timestamp", LocalDateTime.now(),
                                        "a", "b"
                                ))
                                .build()
                )
        );
    }
}
