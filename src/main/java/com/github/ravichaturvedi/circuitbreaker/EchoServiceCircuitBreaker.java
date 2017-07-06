package com.github.ravichaturvedi.circuitbreaker;


import com.github.ravichaturvedi.EchoServiceClient;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class EchoServiceCircuitBreaker extends HystrixCommand<String> {
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
    try {
      Thread.sleep(100);
    } catch (Exception e) {
      // Do nothing
    }
    return "**********";
  }
}
