package com.gordons.urlshortener.repositories;

import com.gordons.urlshortener.models.URLData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class URLRepositoryImpl {

  private List<URLData> shortURLList;

  public URLRepositoryImpl() {
    shortURLList = new ArrayList<>();
  }

  public URLData save(URLData urlData) {
    shortURLList.add(urlData);
    return urlData;
  }


  public URLData findByShortId(String id) {
    List<URLData> result = shortURLList.stream()
        .filter(x -> x.getShortId().equals(id))
        .collect(Collectors.toList());
    return result.get(0);
  }


  public List<URLData> findAll() {
    return shortURLList;
  }

  public List<URLData> deleteByShortId(String id) {
    shortURLList.removeIf(x -> x.getShortId().equals(id));
    return shortURLList;
  }
}
