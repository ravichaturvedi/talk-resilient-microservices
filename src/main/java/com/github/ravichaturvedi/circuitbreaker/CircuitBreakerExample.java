package com.github.ravichaturvedi.circuitbreaker;


import com.netflix.hystrix.HystrixCommand;

public class CircuitBreakerExample {

  public static void main(String[] args) throws Exception {
    while (true){
      HystrixCommand<String> command = new EchoServiceCircuitBreaker();
      System.out.println("Circuit: " + (command.isCircuitBreakerOpen() ? "Open" : "Closed") + ", Value: " + command.execute());
    }
  }
}
