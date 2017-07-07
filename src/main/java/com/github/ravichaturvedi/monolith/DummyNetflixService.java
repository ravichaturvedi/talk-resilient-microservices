package com.github.ravichaturvedi.monolith;

import com.github.ravichaturvedi.app.DefaultMovieManager;
import com.github.ravichaturvedi.app.DefaultMovieRecommender;
import com.github.ravichaturvedi.app.DefaultSubscription;
import com.github.ravichaturvedi.app.JsonTransformer;
import com.github.ravichaturvedi.app.Movie;
import com.github.ravichaturvedi.app.MovieSubscription;
import com.github.ravichaturvedi.app.MoviesManager;
import spark.Spark;

import java.util.List;

import static spark.Spark.port;
import static spark.Spark.post;

public class DummyNetflixService {

  private MoviesManager moviesManager;
  private MovieSubscription movieSubscription;

  public static void main(String[] args) throws Exception {
    new DummyNetflixService(new DefaultMovieManager(new DefaultMovieRecommender()), new DefaultSubscription()).startServer();
  }

  public DummyNetflixService(MoviesManager moviesManager, MovieSubscription movieSubscription) {
    this.moviesManager = moviesManager;
    this.movieSubscription = movieSubscription;
  }

  private void startServer() {
    port(8080);
    Spark.get("/movies", (req, res) -> {
      List<Movie> movies = moviesManager.getMovies();
      System.out.println(movies);
      return movies;
    }, new JsonTransformer());

    post("/subscription",  (req, res) -> {
      movieSubscription.subscribe(Double.parseDouble(req.body()));
      return "";
    });
  }
}
