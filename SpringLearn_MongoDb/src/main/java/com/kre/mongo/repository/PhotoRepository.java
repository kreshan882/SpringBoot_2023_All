package com.kre.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kre.mongo.collection.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}