package com.Elliott.Engineering.Website.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        CustomUserDetails user = userDetailsService.loadUserByUsername(username);

        return checkPassword(user,password,bCryptPasswordEncoder);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

    private Authentication checkPassword(CustomUserDetails user, String rawPassword, PasswordEncoder encoder){
        if(bCryptPasswordEncoder.matches(rawPassword,user.getPassword())){
            return new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities()
            );
        }else{
            throw new BadCredentialsException("Bad credentials");
        }
    }
}
