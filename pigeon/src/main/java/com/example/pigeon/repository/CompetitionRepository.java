package com.example.pigeon.repository;

import com.example.pigeon.entity.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition, String> {

}