package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {


    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public String createUser(User user){
        String encodedUsername = encode(user.getPassword());
        user.setPassword(encodedUsername);
        User savedUser = userRepository.save(user);

        return  " user has been created";
    }

    private String encode(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }
}
