package com.github.ravichaturvedi.microservice;

import com.github.ravichaturvedi.app.DefaultMovieManager;
import com.github.ravichaturvedi.app.DefaultMovieRecommender;
import com.github.ravichaturvedi.app.JsonTransformer;
import com.github.ravichaturvedi.app.Movie;
import com.github.ravichaturvedi.app.MoviesManager;
import spark.Spark;

import java.util.List;

import static spark.Spark.port;

public class MovieService {

  private MoviesManager moviesManager;

  public static void main(String[] args) throws Exception {
    new MovieService(new DefaultMovieManager(new MovieRecommenderClient())).startServer();
  }

  public MovieService(MoviesManager moviesManager) {
    this.moviesManager = moviesManager;
  }

  private void startServer() {
    port(8081);
    Spark.get("/movies", (req, res) -> {
      List<Movie> movies = moviesManager.getMovies();
      System.out.println(movies);
      return movies;
    }, new JsonTransformer());
  }
}
