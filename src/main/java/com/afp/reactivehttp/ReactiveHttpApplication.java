package com.afp.reactivehttp;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.afp.reactivehttp.beans.GreetingRequest;
import com.afp.reactivehttp.beans.GreetingResponse;
import com.afp.reactivehttp.service.GreetingService;

@SpringBootApplication
public class ReactiveHttpApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactiveHttpApplication.class, args);
  }

  @Bean
  RouterFunction<ServerResponse> routes(GreetingService greetingService) {
    return route()
        .GET("/greeting/{name}",
            serverRequest -> ok().body(greetingService.greet(new GreetingRequest(serverRequest.pathVariable("name"))),
                GreetingResponse.class))
        .GET("/greetings/{name}",
            serverRequest -> ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                greetingService.greetMany(new GreetingRequest(serverRequest.pathVariable("name"))),
                GreetingResponse.class))
        .build();
  }

}
