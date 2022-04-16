package com.gordons.urlshortener.repositories;


import com.gordons.urlshortener.models.URLData;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends CrudRepository<URLData, Long> {
  URLData save(URLData urlData);

  Optional<URLData> findByShortId(String id);

  List<URLData> findAll();

  void deleteByShortId(String id);
}
