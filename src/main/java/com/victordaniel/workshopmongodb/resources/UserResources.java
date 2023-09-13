package com.victordaniel.workshopmongodb.resources;

import com.victordaniel.workshopmongodb.Dto.UserDTO;
import com.victordaniel.workshopmongodb.domain.User;
import com.victordaniel.workshopmongodb.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserServices userServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<UserDTO>> findALL(){
        List<User> list = userServices.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //Expressao lambda
        return ResponseEntity.ok().body(listDto);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <UserDTO> findById(@PathVariable String id){
        User obj = userServices.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));

    }

    @PostMapping
    public ResponseEntity <Void> insert (@RequestBody UserDTO objDto){
        User obj = userServices.fromDTO(objDto);
        obj = userServices.insert(obj);;
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity <Void> delete (@PathVariable String id){
        userServices.delete(id);
        return ResponseEntity.noContent().build();

    }

}
