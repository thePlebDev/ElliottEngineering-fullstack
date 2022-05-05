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
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Value("${jwt.secret}")
    private String signingKey;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        String jwt = request.getHeader("Authorization");


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

        String[] urls = {"/api/v1/users/profile","/api/v1/users/testing","/api/v1/users/authOnly",};
        boolean indicator = Arrays.stream(urls).anyMatch((i)-> Objects.equals(i, URLPath));
        return !indicator; // should apply filter to this path
    }

}
