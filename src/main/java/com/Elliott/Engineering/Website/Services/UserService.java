package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;


//    @Autowired
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }


    public String createUser(User user){
        User savedUser = userRepository.save(user);
        //String username = savedUser.getUsername();

        return  " user has been created";

    }
}
