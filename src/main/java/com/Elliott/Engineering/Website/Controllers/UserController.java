package com.Elliott.Engineering.Website.Controllers;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @PostMapping("/login")
    public String login(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long userId = userService.getUserId(username);
        System.out.println(username);
        return "Success";
    }

    @PostMapping("/testing")
    public String moreTest(){
        return "CAN YOU SEE THIS";
    }

    @PostMapping("/profile")
    public String createTesting(){
        //System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());//use this to get the id

        return "User is authenticated";
    }

}
