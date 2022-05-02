package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServicesTest {

    UserService underTest;

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder passwordEncoder;


    @BeforeEach
    void init(){
        underTest = new UserService(userRepository, passwordEncoder);
    }


    @Test
    public void createUserTest(){
        //GIVEN
        String EXPECTED_PASSWORD = "12345";
        User user = new User("username",EXPECTED_PASSWORD,"bob@bobmail.com","READ");

        //WHEN
        when(passwordEncoder.encode(EXPECTED_PASSWORD)).thenReturn(EXPECTED_PASSWORD);
        underTest.createUser(user);

        //THEN
        verify(passwordEncoder,times(1)).encode(EXPECTED_PASSWORD);

    }
}
