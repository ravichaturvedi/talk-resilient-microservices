package com.github.ravichaturvedi.retry;

import com.github.ravichaturvedi.EchoServiceClient;
import com.github.ravichaturvedi.Sleeper;



public class RetryMain {

  public static void main(String[] args) throws Exception {
    withoutRetry();
//    withRetry();
  }

  private static void withoutRetry() {
    while (true) {
      try {
        System.out.println(EchoServiceClient.echo("Ravi"));
      } catch (Exception e) {
        System.out.println("Error occurred: " + e.getMessage());
      }
      Sleeper.sleep(300);
    }
  }

  private static void withRetry() {
    while (true) {
      try {
        System.out.println(EchoServiceClient.echoWithRetry("Ravi"));
      } catch (Exception e) {
        System.out.println("Error occurred: " + e.getMessage());
      }
      Sleeper.sleep(300);
    }
  }

}
