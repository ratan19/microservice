package com.ratan.learn.restfull.springjpa.service;


import com.ratan.learn.restfull.springjpa.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {


    private static List<User> userList = new ArrayList<>();

    private static int count = 3;
    static{

        userList.add(new User(100,"ratan", new Date()));
        userList.add(new User(101,"gautam", new Date()));
        userList.add(new User(102,"kunal", new Date()));
    }

    public List<User> findAll(){
        return userList;
    }


    public User save(User user){

        if(user.getId() == null){
            count++;
            user.setId(count);
        }
        userList.add(user);
        return user;
    }

    public User findById(Integer id){

        for(User user : userList){
            if(user.getId() == id){
                return user;
            }
        }

        return null;

    }
}
