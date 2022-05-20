package com.Elliott.Engineering.Website.Controllers;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Controller used to handle all the user interactions
 *
 * */
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public String login(){
        return "Success";
    }

    @PostMapping("/authOnly")
    public String authenticate(){
        return "Success";
    }

}
