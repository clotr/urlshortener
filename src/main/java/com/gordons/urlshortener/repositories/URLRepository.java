package com.gordons.urlshortener.repositories;


import com.gordons.urlshortener.models.URLData;

public interface URLRepository {
  String addURL(URLData urlData);

  String findId(String id);
}
