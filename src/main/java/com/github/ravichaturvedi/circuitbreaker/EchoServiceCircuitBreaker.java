package com.github.ravichaturvedi.circuitbreaker;


import com.github.ravichaturvedi.EchoServiceClient;
import com.github.ravichaturvedi.Sleeper;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.Random;

public class EchoServiceCircuitBreaker extends HystrixCommand<String> {

  private static final Random random = new Random();

  private static HystrixCommand.Setter setter = HystrixCommand.Setter
      .withGroupKey(HystrixCommandGroupKey.Factory.asKey("hello-world"))
      .andCommandPropertiesDefaults(
          HystrixCommandProperties.Setter()
              .withCircuitBreakerRequestVolumeThreshold(3)
              .withCircuitBreakerSleepWindowInMilliseconds(500));

  public EchoServiceCircuitBreaker() {
    super(setter);
  }

  protected String run() throws Exception {
    return EchoServiceClient.echo("Ravi");
  }

  @Override
  protected String getFallback() {
    Sleeper.sleep(300);
    return "**********";
  }
}
