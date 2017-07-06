package com.github.ravichaturvedi;


public class Sleeper {

  public static void sleep(int sleepTimeInMillisec) {
    try {
      Thread.sleep(sleepTimeInMillisec);
    } catch (Exception e) {
      // do nothing
    }
  }
}
