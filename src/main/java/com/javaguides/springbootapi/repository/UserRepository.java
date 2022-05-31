package com.javaguides.springbootapi.repository;

import com.javaguides.springbootapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
    //CRUD Methods
}
