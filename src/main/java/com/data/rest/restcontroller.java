package com.data.rest;



import com.data.dataservice.ContentCoreService;
import com.data.entity.MovieListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
