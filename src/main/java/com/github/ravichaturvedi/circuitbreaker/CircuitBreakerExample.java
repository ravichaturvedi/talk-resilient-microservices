package com.github.ravichaturvedi.circuitbreaker;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class CircuitBreakerExample {

  public static void main(String[] args) throws Exception {
    HystrixCommand.Setter setter = HystrixCommand.Setter
        .withGroupKey(HystrixCommandGroupKey.Factory.asKey("hello-world"))
        .andCommandPropertiesDefaults(
            HystrixCommandProperties.Setter()
                .withCircuitBreakerRequestVolumeThreshold(5)
                .withCircuitBreakerSleepWindowInMilliseconds(500));

    for (int i = 0; i < 100; i++) {
      HystrixCommand<String> command = new EchoServiceCircuitBreaker(setter);
      System.out.println("Circuit: " + (command.isCircuitBreakerOpen() ? "Open" : "Closed") + ", Value: " + command.execute());
      Thread.sleep(500);
    }
  }
}
