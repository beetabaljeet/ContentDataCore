package com.data.contentdatacore;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoTests
{

    @Test
    public void TestMono()
    {
      Mono<?>  monoString = Mono.just("Mono testing").then(Mono.error( new RuntimeException("data error"))).log();
      monoString.subscribe(System.out::println,(e)->System.out.print(e.getMessage()));
    }


    @Test
    public void TestFlux()
    {
      Flux<?>  fluxString = Flux.just("Java","Hibernate","Spring MVC").thenMany(Flux.error(new RuntimeException()));
      fluxString.subscribe(System.out::println);
    }
}


