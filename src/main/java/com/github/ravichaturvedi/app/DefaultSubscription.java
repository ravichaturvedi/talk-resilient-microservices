package com.github.ravichaturvedi.app;

/**
 * Created by ravi on 07/07/17.
 */
public class DefaultSubscription implements MovieSubscription {

  @Override
  public void subscribe(double amount) {
    System.out.println("You are now a lifetime subscriber of DummyNetflix!");
  }
}
