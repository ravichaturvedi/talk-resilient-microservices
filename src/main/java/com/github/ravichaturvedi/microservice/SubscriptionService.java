package com.github.ravichaturvedi.microservice;

import com.github.ravichaturvedi.app.DefaultSubscription;
import com.github.ravichaturvedi.app.MovieSubscription;
import com.github.ravichaturvedi.app.MoviesManager;

import static spark.Spark.port;
import static spark.Spark.post;

public class SubscriptionService {

  private MovieSubscription movieSubscription;

  public static void main(String[] args) throws Exception {
    new SubscriptionService(new DefaultSubscription()).startServer();
  }

  public SubscriptionService(MovieSubscription movieSubscription) {
    this.movieSubscription = movieSubscription;
  }

  private void startServer() {
    port(8082);
    post("/subscription",  (req, res) -> {
      movieSubscription.subscribe(Double.parseDouble(req.body()));
      return "You are now a lifetime subscriber of DummyNetflix!";
    });
  }
}
