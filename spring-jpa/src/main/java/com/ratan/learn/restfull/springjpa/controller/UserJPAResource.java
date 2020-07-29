package com.ratan.learn.restfull.springjpa.controller;


import com.ratan.learn.restfull.springjpa.entity.Post;
import com.ratan.learn.restfull.springjpa.entity.User;
import com.ratan.learn.restfull.springjpa.exception.UserNotFoundException;
import com.ratan.learn.restfull.springjpa.repository.UserJPARepository;
import com.ratan.learn.restfull.springjpa.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJPAResource {


    @Autowired
    private UserDaoService userDaoService;


    @Autowired
    private UserJPARepository userJPARepository;



    @GetMapping(path = "/jpa/users")
    public List<User> getAllUsers(){

        return userJPARepository.findAll();
    }


    @GetMapping(path = "/jpa/users/{id}")
    public Resource<User> findUser(@PathVariable int id)  {

        Optional<User> user  = userJPARepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found for id:"+id);
        }

        Resource<User> resource = new Resource<>(user.get());
        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(link.withRel("all-user"));

        return resource;
    }


    @DeleteMapping (path = "/jpa/users/{id}")
    public void deleteUser(int id){

        userJPARepository.deleteById(id);

    }

    @PostMapping(path = "/jpa/users")
    public  ResponseEntity<Object> createUser(@Valid @RequestBody User user){

        User savedUser = userJPARepository.save(user);

        URI newLocation  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(newLocation).body(null);
    }


    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> findAllPostForUser(@PathVariable int id)  {

        Optional<User> user  = userJPARepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found for id:"+id);
        }


        List<Post> list = user.get().getPost();

        return list;
    }
}
