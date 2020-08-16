package com.afp.reactivehttp.service;

import com.afp.reactivehttp.beans.GreetingRequest;
import com.afp.reactivehttp.beans.GreetingResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 *  
 * </p>
 * 
 * @author Andrés Felipe Posada Ramírez.
 * @since Aug 16, 2020 5:58:57 PM
 * @version 1.0
 *
 */
public interface GreetingService {
  
  Mono<GreetingResponse> greet(GreetingRequest request);
  
  Flux<GreetingResponse> greetMany(GreetingRequest request);

}
