package com.example.demo.repository;

import com.example.demo.jms.EmailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Integer> {
}
