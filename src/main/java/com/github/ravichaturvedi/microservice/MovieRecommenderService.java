package com.github.ravichaturvedi.microservice;

import com.github.ravichaturvedi.app.DefaultMovieRecommender;
import com.github.ravichaturvedi.app.JsonTransformer;
import com.github.ravichaturvedi.app.Movie;
import com.github.ravichaturvedi.app.MovieRecommender;
import spark.Spark;

import java.util.List;

import static spark.Spark.port;

public class MovieRecommenderService {

  private MovieRecommender movieRecommender;

  public static void main(String[] args) throws Exception {
    new MovieRecommenderService(new DefaultMovieRecommender()).startServer();
  }

  public MovieRecommenderService(MovieRecommender movieRecommender) {
    this.movieRecommender = movieRecommender;
  }

  private void startServer() {
    port(8084);
    Spark.get("/movie-recommender", (req, res) -> {
      List<Movie> movies = movieRecommender.recommendMovies();
      System.out.println(movies);
      return movies;
    }, new JsonTransformer());
  }
}
