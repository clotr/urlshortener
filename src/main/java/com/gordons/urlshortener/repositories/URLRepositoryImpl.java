package com.gordons.urlshortener.repositories;

import com.gordons.urlshortener.models.URLData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class URLRepositoryImpl
    implements URLRepository {

  private List<URLData> shortURLList;

  public URLRepositoryImpl() {
    shortURLList = new ArrayList<>();
  }

  public String addURL(URLData urlData) {
    shortURLList.add(urlData);
    return urlData.getId().toString();
  }

  @Override
  public String findId(String id) {
    String longURL;
    List<URLData> result = shortURLList.stream()
        .filter(x -> x.getId().equals(id))
        .collect(Collectors.toList());
    longURL = result.get(0).getLongURL();
    return longURL;
  }
}
