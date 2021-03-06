package com.Elliott.Engineering.Website.Security;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = ()-> new UsernameNotFoundException("User not found");

        try{
            User user = userRepository.findByUsername(username).orElseThrow(s);
            return new CustomUserDetails(user);
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());

            throw new UsernameNotFoundException("PROBLEM DURING AUTHENTICATION");

        }


    }
}
