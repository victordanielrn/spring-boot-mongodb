package com.victordaniel.workshopmongodb.repository;

import com.victordaniel.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {
}