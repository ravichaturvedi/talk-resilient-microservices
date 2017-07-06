package com.github.ravichaturvedi;

import java.util.Random;
import static spark.Spark.*;

public class EchoService {

  private static final Random random = new Random();

  public static void main(String[] args) throws Exception {
    get("/echo", (req, res) -> {
      int sleepTimeInMillisec = 300;
      System.out.println("######## Sleeping for timeInMillisec: " + sleepTimeInMillisec);
      Thread.sleep(sleepTimeInMillisec);

      // Identify do we want to discard this request
      if (random.nextBoolean()) {
        System.out.println("****** Request selected to DISCARD...");
        res.status(400);
        return "";
      }

      // Returned the ecoed response.
      System.out.println("######## Received Query Params: " + req.queryParams());
      System.out.println();
      System.out.println();
      return req.queryParams("name") + "!";
    });
  }
}
