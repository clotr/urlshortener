package com.gordons.urlshortener.repositories;


import com.gordons.urlshortener.models.URLData;
import java.util.List;

public interface URLRepository {
  String addURL(URLData urlData);

  String findId(String id);

  List<URLData> findAll();

  List<URLData> deleteId(String id);
}
