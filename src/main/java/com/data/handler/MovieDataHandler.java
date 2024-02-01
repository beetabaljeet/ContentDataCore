package com.data.handler;

import com.data.dataservice.ContentCoreServiceImp;
import com.data.entity.MovieListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieDataHandler {

    @Autowired
    private ContentCoreServiceImp contentCoreServiceImp;


    public Mono<ServerResponse> getMovieList(ServerRequest request){
        Flux<MovieListData> customerList = contentCoreServiceImp.getMovieListDataStream();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(customerList,MovieListData.class);
    }


    public Mono<ServerResponse> findMovie(ServerRequest request){
      int movieId= Integer.valueOf( request.pathVariable("input"));

        Mono<MovieListData> customerMono = contentCoreServiceImp.getMovieListDataStream().filter(c -> c.getMovieId() == movieId).next();
        return ServerResponse.ok().body(customerMono,MovieListData.class);
    }


    public Mono<ServerResponse> uploadMovieData(ServerRequest request){
        Mono<MovieListData> movieListDataMono = request.bodyToMono(MovieListData.class);
        Mono<String> saveResponse = movieListDataMono.map(dto -> dto.getMovieName() + ":" + dto.getMovieType());
        return ServerResponse.ok().body(saveResponse,String.class);
    }



}
