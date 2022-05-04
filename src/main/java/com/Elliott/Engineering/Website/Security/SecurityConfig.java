package com.Elliott.Engineering.Website.Security;

import com.Elliott.Engineering.Website.Security.Filters.FilterChainExceptionHandler;
import com.Elliott.Engineering.Website.Security.Filters.InitialAuthenticationFilter;
import com.Elliott.Engineering.Website.Security.Filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private FilterChainExceptionHandler filterChainExceptionHandler;


    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();

        http.addFilterBefore(filterChainExceptionHandler,BasicAuthenticationFilter.class);
        http.addFilterAt(
                new InitialAuthenticationFilter(authenticationManager()),
                BasicAuthenticationFilter.class
        );
        http.addFilterAfter(jwtAuthenticationFilter,
                BasicAuthenticationFilter.class);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
}
