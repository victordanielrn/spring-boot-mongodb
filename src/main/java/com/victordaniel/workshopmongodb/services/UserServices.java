package com.victordaniel.workshopmongodb.services;

import com.victordaniel.workshopmongodb.Dto.UserDTO;
import com.victordaniel.workshopmongodb.domain.User;
import com.victordaniel.workshopmongodb.repository.UserRepository;
import com.victordaniel.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById (String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public void delete (String id){
        findById(id);
        userRepository.deleteById(id);

    }


    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
