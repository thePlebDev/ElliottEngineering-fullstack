package com.Elliott.Engineering.Website.Security.Filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Value("${jwt.secret}")
    private String signingKey;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("PROBLEM DURING AUTHENTICATION");
        String jwt = Optional.of(request.getHeader("Authorization")).orElseThrow(s);
        //String jwt = request.getHeader("Authorization");


        SecretKey key = Keys.hmacShaKeyFor(
                signingKey.getBytes(StandardCharsets.UTF_8)
        );
        Claims claims = Jwts.parserBuilder()//THIS WILL VERIFY THE SIGNATURE
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        String username = String.valueOf(claims.get("username"));
        GrantedAuthority a = new SimpleGrantedAuthority("READ");
        Authentication auth = new UsernamePasswordAuthenticationToken(
                username,
                null,
                List.of(a)
        );
        SecurityContextHolder.getContext()
                .setAuthentication(auth);

        filterChain.doFilter(request,response);
    }


    @Override
    protected  boolean shouldNotFilter(HttpServletRequest request){
        // ! == we do  apply the filter
        String URLPath =request.getServletPath();
        System.out.println(URLPath);
        String[] urls = {"/api/v1/blog/save-post","/api/v1/users/authOnly"};
        boolean indicator = Arrays.asList(urls).contains(URLPath);
        //Arrays.stream(urls).anyMatch(i-> i.contains(URLPath));

        return !indicator; // should apply filter to this path
    }

}
