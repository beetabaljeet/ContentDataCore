package com.data.dataservice;


import com.data.entity.MovieListData;
import com.data.respository.MovieDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentCoreServiceImp implements ContentCoreService
{

     @Autowired
     public MovieDataRepo movieDataRepo;

    @Override
    public List<MovieListData> getAllMovieList() {
        return movieDataRepo.findAll();
        //return null;
    }
}
