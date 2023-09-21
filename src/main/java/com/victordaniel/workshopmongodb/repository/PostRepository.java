package com.victordaniel.workshopmongodb.repository;

import com.victordaniel.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {


    List<Post> findByTitleContainingIgnoreCase(String text);
    //Para quando pesquisar não ter interferencia se a letra e maiuscula ou minuscula
}