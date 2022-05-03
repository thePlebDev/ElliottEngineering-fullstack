package com.Elliott.Engineering.Website.Security.Filters;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {


    private AuthenticationManager manager;

    private String signingKey = "asaf;jdoaruehqpurnagrefsdSECRETfdsafpojtuk7906u65";

    @Autowired
    public InitialAuthenticationFilter(AuthenticationManager authenticationManager){
        this.manager = authenticationManager;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");

        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("MADE IT TO THE INITIAL AUTHENTICATION FILTER");
        System.out.println("---------------------");
        System.out.println("---------------------");

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
        manager.authenticate(auth);//this will delegate to our CustomAuthenticationProvider

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
