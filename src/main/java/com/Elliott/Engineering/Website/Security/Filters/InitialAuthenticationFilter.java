package com.Elliott.Engineering.Website.Security.Filters;

import com.Elliott.Engineering.Website.Exceptions.CustomAuthenticationException;
import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import com.Elliott.Engineering.Website.Security.CustomAuthenticationProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String signingKey;

    @Autowired
   private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("PROBLEM DURING AUTHENTICATION");


        String username = Optional.of(request.getHeader("username")).orElseThrow(s);
        String password = Optional.of(request.getHeader("password")).orElseThrow(s);

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);

        try{
            customAuthenticationProvider.authenticate(auth);
            //assign the JWT header and the userId header
            jwtMethod(username,response);

        } catch (AuthenticationException e) {
           throw  new CustomAuthenticationException("Username or password Incorrect");
        }

        SecurityContextHolder.getContext()
                .setAuthentication(auth);

        filterChain.doFilter(request,response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        return !request.getServletPath().equals("/api/v1/users/login"); // filter only applies to this path
       // !request.getServletPath().equals("/api/v1/user/login");
    }

    private void jwtMethod(String username,HttpServletResponse response){
        SecretKey key = Keys.hmacShaKeyFor(
                signingKey.getBytes(StandardCharsets.UTF_8)
        );


        String jwt = Jwts.builder()
                .setClaims(Map.of("username",username))
                .signWith(key)
                .compact();
        response.setHeader("Authorization",jwt);
        response.setHeader("userId", findUserId(username).toString());

    }
    private Long findUserId(String username){
        User foundUser = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return foundUser.getId();
    }
}
