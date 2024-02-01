package com.data.dataservice;



import com.data.entity.MovieListData;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ContentCoreService {

    public List<MovieListData> getAllMovieList();

    public Flux<MovieListData> getMovieListDataStream();

    public Mono<Resource> playMovieFromS3Storage(String tital);
}
