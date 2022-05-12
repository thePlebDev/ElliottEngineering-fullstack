package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    public Long getUserId(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return user.getId();
    }


    public String createUser(User user){
        String encodedUsername = encode(user.getPassword());
        user.setPassword(encodedUsername);
        try{
            User savedUser = userRepository.save(user);

            return  " user has been created";
        } catch (Exception e) {
            throw new UsernameNotFoundException("Username already exists");
        }

    }

    private String encode(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }
}
