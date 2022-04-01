package com.gordons.urlshortener.services;

import com.gordons.urlshortener.models.URLData;
import com.gordons.urlshortener.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class URLServiceImpl implements URLService {
  private URLRepository urlRepository;

  @Value("${baseURL}")
  private String baseURL;

  public URLServiceImpl(URLRepository urlRepository) {
    this.urlRepository = urlRepository;
  }

  public String addURL(String url) {
    return urlRepository.addURL(new URLData(url));
  }

  @Override
  public String findId(String id) {
    return urlRepository.findId(id);
  }
}
