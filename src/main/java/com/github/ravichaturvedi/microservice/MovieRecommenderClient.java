package com.github.ravichaturvedi.microservice;


import com.github.ravichaturvedi.app.Movie;
import com.github.ravichaturvedi.app.MovieRecommender;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import java.util.Arrays;
import java.util.List;

public class MovieRecommenderClient implements MovieRecommender {

  @Override
  public List<Movie> recommendMovies() {
    try {
      Movie[] movies = new Gson().fromJson(Unirest.get("http://localhost:8084/movie-recommender").asString().getBody(), Movie[].class);
      return Arrays.asList(movies);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
