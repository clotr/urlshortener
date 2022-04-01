package com.gordons.urlshortener.services;

import org.springframework.stereotype.Service;


public interface URLService {
  String addURL(String url);

  String findId(String id);
}
