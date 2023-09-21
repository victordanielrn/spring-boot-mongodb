package com.victordaniel.workshopmongodb.services;

import com.victordaniel.workshopmongodb.Dto.UserDTO;
import com.victordaniel.workshopmongodb.domain.Post;
import com.victordaniel.workshopmongodb.domain.User;
import com.victordaniel.workshopmongodb.repository.PostRepository;
import com.victordaniel.workshopmongodb.repository.UserRepository;
import com.victordaniel.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {
    @Autowired
    private PostRepository postRepository;

    public Post findById (String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public List<Post>findByTitle(String text){
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch (String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
