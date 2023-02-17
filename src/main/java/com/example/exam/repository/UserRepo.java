package com.example.exam.repository;

import com.example.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>{

    Optional<User> findUserByUsername(String name);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(long id);
}
