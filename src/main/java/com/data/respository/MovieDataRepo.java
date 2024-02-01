package com.data.respository;


import com.data.entity.MovieListData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDataRepo extends JpaRepository<MovieListData,Integer>
{

}
