package com.stockTracker;

import com.stocktracker.springbootgraphql.models.types.Book;
import com.stocktracker.springbootgraphql.models.types.Brand;
import com.stocktracker.springbootgraphql.models.types.Electronic;
import com.stocktracker.springbootgraphql.models.types.Fruit;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

@Controller
public class SearchEngineController {

    List<Object> list = List.of(
            Book.newBuilder().title("The Lord of the Rings").author("J.R.R. Tolkien").build(),
            Book.newBuilder().title("The Hobbit").author("J.R.R. Tolkien").build(),
            Book.newBuilder().title("The Silmarillion").author("J.R.R. Tolkien").build(),
            Electronic.newBuilder().id("iPhone 12").description("desc1").price(123).brand(Brand.APPLE).build(),
            Electronic.newBuilder().id("iPhone 11").description("desc2").price(123).brand(Brand.APPLE).build(),
            Fruit.newBuilder().description("desc3").expireDate(String.valueOf(LocalDate.now().plusDays(1))).build(),
            Fruit.newBuilder().description("desc4").expireDate(String.valueOf(LocalDate.now().plusDays(2))).build()
            );

    @QueryMapping
    public Flux<Object> search() {
        return Mono.fromSupplier(() -> new ArrayList<>(list))
                .doOnNext(Collections::shuffle)
                .flatMapIterable(Function.identity())
                .take(ThreadLocalRandom.current().nextInt(0, list.size()));
    }

}
