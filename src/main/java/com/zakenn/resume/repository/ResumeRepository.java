package com.zakenn.resume.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends ReactiveMongoRepository<Resume,String> {
}
