package com.example.demooauth2.repositories;

import com.example.demooauth2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsernameOrEmail(String username, String email);

}
