package com.github.ravichaturvedi;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import static io.github.ravichaturvedi.retrier.Retry.*;

public class EchoServiceClient {

  public static String echoWithRetry(String name) throws Exception {
    return retry(() -> echo(name));
  }

  public static String echo(String name) throws Exception {
    HttpResponse<String> httpResponse = Unirest.get("http://localhost:4567/echo?name=" + name).asString();
    if (httpResponse.getStatus() != 200) {
      throw new IllegalStateException(httpResponse.getStatusText());
    }
    return httpResponse.getBody() + "!";
  }
}
