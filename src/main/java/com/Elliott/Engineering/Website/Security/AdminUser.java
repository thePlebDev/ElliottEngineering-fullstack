package com.Elliott.Engineering.Website.Security;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminUser implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("","","",null);
        userService.createUser(user);

    }
}
