package com.github.ravichaturvedi.app;

import java.util.List;

/**
 * Created by ravi on 07/07/17.
 */
public class DefaultMovieManager implements MoviesManager {

  private MovieRecommender movieRecommender;

  public DefaultMovieManager(MovieRecommender movieRecommender) {
    this.movieRecommender = movieRecommender;
  }

  @Override
  public List<Movie> getMovies() {
    return movieRecommender.recommendMovies();
  }
}
