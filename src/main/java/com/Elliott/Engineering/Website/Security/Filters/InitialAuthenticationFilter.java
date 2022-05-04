package com.Elliott.Engineering.Website.Security.Filters;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final Logger log = LoggerFactory.getLogger(getClass());



    private AuthenticationManager manager;

    private String signingKey = "asaf;jdoaruehqpurnagrefsdSECRETfdsafpojtuk7906u65";

    @Autowired
    public InitialAuthenticationFilter(AuthenticationManager authenticationManager){
        this.manager = authenticationManager;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("PROBLEM DURING AUTHENTICATION");

        String username = Optional.of(request.getHeader("username")).orElseThrow(s);
        String password = Optional.of(request.getHeader("password")).orElseThrow(s);
       // String username = Optional.of(request.getHeader("username")).orElseThrow(new UsernameNotFoundException("usernmae"));

        System.out.println("PASSWORD AND USERNAME NOT BEING THROWN");
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);

            manager.authenticate(auth);

        //this will delegate to our CustomAuthenticationProvider

        SecretKey key = Keys.hmacShaKeyFor(
                signingKey.getBytes(StandardCharsets.UTF_8)
        );

        String jwt = Jwts.builder()
                .setClaims(Map.of("username",username))
                .signWith(key)
                .compact();
        response.setHeader("Authorization",jwt);

        System.out.println(jwt);
        filterChain.doFilter(request,response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        return !request.getServletPath().equals("/api/v1/users/login"); // avoid filtering this path
       // !request.getServletPath().equals("/api/v1/user/login");
    }
}
