package com.example.demo.repository;

import com.example.demo.model.entity.Energy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyRepository extends CrudRepository<Energy, Integer> {
}
