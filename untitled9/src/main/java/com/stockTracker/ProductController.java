package com.stockTracker;

import com.stocktracker.springbootgraphql.models.types.Books;
import com.stocktracker.springbootgraphql.models.types.Fruit;
import com.stocktracker.springbootgraphql.models.types.Product;
import graphql.com.google.common.base.Objects;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ProductController {

    @QueryMapping
    public Flux<Product> products() {
        return Flux.just(
                Fruit.newBuilder().id("1")
                        .description("Apple")
                        .price(42)
                        .expiryDate("2021-12-12").build(),
                Fruit.newBuilder().id("2")
                        .description("Banana")
                        .price(12)
                        .expiryDate("2021-12-12").build(),
                Books.newBuilder().id("3")
                        .description("Book")
                        .price(100)
                        .author("Author").build(),
                Books.newBuilder().id("4")
                        .description("Book")
                        .price(100)
                        .author("Author").build());
    }
}
