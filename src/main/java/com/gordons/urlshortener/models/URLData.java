package com.gordons.urlshortener.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class URLData {
  private String longURL;
  private String id;
  private LocalDateTime date;

  public URLData(String longURL) {
    this.longURL = longURL;
    this.id = UUID.randomUUID().toString().substring(0,7);
    this.date = LocalDateTime.now();
  }

  public String getLongURL() {
    return longURL;
  }

  public void setLongURL(String longURL) {
    this.longURL = longURL;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDateTime getDate() {
    return date;
  }
}
