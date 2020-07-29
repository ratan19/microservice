package com.ratan.learn.restfull.springjpa.controller;


import com.ratan.learn.restfull.springjpa.entity.User;
import com.ratan.learn.restfull.springjpa.exception.UserNotFoundException;
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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class UserResource {


    @Autowired
    private UserDaoService userDaoService;



    @GetMapping(path = "/users")
    public List<User> getAllUsers(){

        return userDaoService.findAll();
    }


    @GetMapping(path = "/users/{id}")
    public Resource<User> findUser(@PathVariable int id)  {

        User user  = userDaoService.findById(id);
        if(user == null){
            throw new UserNotFoundException("User not found for id:"+id);
        }

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(link.withRel("all-user"));

        return resource;
    }

    @PostMapping(path = "/users")
    public  ResponseEntity<Object> createUser(@Valid @RequestBody User user){

        User savedUser = userDaoService.save(user);

        URI newLocation  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(newLocation).body(null);
    }
}
