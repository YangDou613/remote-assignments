package com.example.assignment3.repository;

import com.example.assignment3.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>
{
    List<User> findByEmail(String email);
    List<User> findByPassword(String password);
}
