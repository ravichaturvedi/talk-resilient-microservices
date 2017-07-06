package com.github.ravichaturvedi.circuitbreaker;


import com.netflix.hystrix.HystrixCommand;

import java.util.concurrent.atomic.AtomicInteger;


public class EchoServiceCircuitBreaker extends HystrixCommand<String> {

  private static final AtomicInteger count = new AtomicInteger(0);

  public EchoServiceCircuitBreaker(Setter setter) {
    super(setter);
  }

  protected String run() throws Exception {
    count.incrementAndGet();
    if (count.get() >= 3 && count.get() <=10) {
      throw new IllegalStateException("Some state issue.");
    }
    return "Hello World!";
  }

  @Override
  protected String getFallback() {
    return "**********";
  }
}
