package com.gordons.urlshortener.services;

import com.gordons.urlshortener.models.URLData;
import java.util.List;
import org.springframework.stereotype.Service;


public interface URLService {
  String addURL(String url);

  String findId(String id);

  List<URLData> findAll();

  List<URLData> deleteId(String id);
}
