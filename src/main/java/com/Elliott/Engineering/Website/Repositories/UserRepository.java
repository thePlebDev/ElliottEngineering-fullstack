package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM users WHERE users.username = ?1",nativeQuery = true)
    public Optional<User> findByUsername(String username);



}
