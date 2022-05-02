package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {



}
