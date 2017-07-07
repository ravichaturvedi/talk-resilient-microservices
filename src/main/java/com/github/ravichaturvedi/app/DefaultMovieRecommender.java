package com.github.ravichaturvedi.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ravi on 07/07/17.
 */
public class DefaultMovieRecommender implements MovieRecommender {

  @Override
  public List<Movie> recommendMovies() {
    return Arrays.asList("Pursuit of Happiness", "Inception", "The Great Gatsby").stream()
        .map(Movie::new)
        .collect(Collectors.toList());
  }
}
