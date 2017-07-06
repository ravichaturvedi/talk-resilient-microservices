package com.github.ravichaturvedi.circuitbreaker;


public class CircuitBreakerExample {

  public static void main(String[] args) throws Exception {
    for (int i = 0; i < 100; i++) {
      System.out.println(new SampleCircuitBreaker("hello-world").execute());
    }
  }
}
