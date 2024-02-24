package com.example.demo.repository;

import com.example.demo.jms.WatchDog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchDogRepository extends CrudRepository<WatchDog, Integer> {
}
