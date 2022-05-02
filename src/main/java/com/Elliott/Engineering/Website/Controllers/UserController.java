package com.Elliott.Engineering.Website.Controllers;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
