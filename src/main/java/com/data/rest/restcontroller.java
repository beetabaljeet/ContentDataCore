package com.data.rest;



import com.data.dataservice.ContentCoreService;
import com.data.entity.MovieListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class restcontroller
{

    @Autowired
    public ContentCoreService contentCoreService;

    @GetMapping(value = "/get-new_movie_list")
    public List<MovieListData> getCoreNewMovieList()
    {
         return contentCoreService.getAllMovieList();
    }

    @GetMapping(value = "/get_new_movie_list_stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieListData> getCoreNewMovieStream()
    {
        return contentCoreService.getMovieListDataStream();
    }


    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title)
    {
        return contentCoreService.playMovieFromS3Storage(title);
    }


}
