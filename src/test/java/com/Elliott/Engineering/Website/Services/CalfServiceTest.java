package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.CalfRepository;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class CalfServiceTest {

    private CalfService underTest;

    @Mock
    private CalfRepository calfRepository;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void init(){
        underTest = new CalfService(calfRepository, userRepository);
    }
    
}
