package com.ratan.learn.restfull.springjpa.repository;

import com.ratan.learn.restfull.springjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User,Integer> {

}
