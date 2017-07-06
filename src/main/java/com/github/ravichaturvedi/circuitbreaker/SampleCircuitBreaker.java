package com.github.ravichaturvedi.circuitbreaker;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.atomic.AtomicInteger;


public class SampleCircuitBreaker extends HystrixCommand<String> {

  private static final AtomicInteger count = new AtomicInteger(0);

  public SampleCircuitBreaker(String name) {
    super(HystrixCommandGroupKey.Factory.asKey(name));
  }

  protected String run() throws Exception {
    if (count.get() >= 3 && count.get() <=10) {
      throw new IllegalStateException("Some state issue.");
    }
    count.incrementAndGet();
    return "Hello World!";
  }
}
