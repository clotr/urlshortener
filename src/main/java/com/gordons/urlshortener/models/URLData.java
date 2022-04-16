package com.gordons.urlshortener.models;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class URLData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  @Column(length = 2048)
  private String longURL;
  private String shortId;
  private LocalDateTime date;

  public URLData() {
  }

  public URLData(String longURL) {
    this.longURL = longURL;
    this.shortId = UUID.randomUUID().toString().substring(0,7);
    this.date = LocalDateTime.now();
  }

  public String getLongURL() {
    return longURL;
  }

  public void setLongURL(String longURL) {
    this.longURL = longURL;
  }

  public String getShortId() {
    return shortId;
  }

  public void setShortId(String id) {
    this.shortId = id;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
