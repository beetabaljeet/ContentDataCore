package com.data.dataservice;


import com.data.entity.MovieListData;
import com.data.respository.MovieDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ContentCoreServiceImp implements ContentCoreService
{

    @Autowired
    private ResourceLoader resourceLoader;


     @Autowired
     public MovieDataRepo movieDataRepo;

    @Override
    public List<MovieListData> getAllMovieList() {
       // return movieDataRepo.findAll();
        //return null;
       return getMovieListData();
    }



    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<MovieListData> getMovieListData()  {
        return IntStream.rangeClosed(1, 10)
                .peek(ContentCoreServiceImp::sleepExecution)
                .peek(i -> System.out.println("processing count : " + i))
                .mapToObj(i -> new MovieListData( i, "movie name","Hindi" ,"3 hour","clip","test",null,""))
                .collect(Collectors.toList());
    }



    public Flux<MovieListData> getMovieListDataStream()
    {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new MovieListData(i, "movie name","Hindi" ,"3 hour","clip","test",null,""));
    }

    @Override
    public Mono<Resource> playMovieFromS3Storage(String tital)
    {
        String FORMAT = "classpath:videos/%s.mp4";
        return Mono.fromSupplier(() -> this.resourceLoader.getResource(String.format(FORMAT,tital)));
    }
}
