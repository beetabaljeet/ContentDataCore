package com.data.router;


import com.data.handler.MovieDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private MovieDataHandler handler;

    @Autowired
  //  private CustomerStreamHandler streamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/movie_list",handler::getMovieList)
              //  .GET("/router/customers/stream",streamHandler::getCustomers)
                .GET("/router/movie/{input}",handler::findMovie)
                .POST("/router/movie/save",handler::uploadMovieData)
                .build();

    }
}
